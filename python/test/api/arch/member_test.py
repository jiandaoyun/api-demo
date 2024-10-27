import unittest
from unittest.mock import patch
from src.model.user.user_create_param import UserCreateParam
from src.model.user.user_update_param import UserUpdateParam
from src.api.arch.member import MemberApiClient
from src.constants.http_constant import HttpConstant
import random

memberApiClient = MemberApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

random = str(random.randint(100, 200))
name = 'name' + random
user_name = 'user_name' + random

deptNo = 1

user_create_param = UserCreateParam(name, user_name)
departments = [deptNo]
user_create_param.setDepartments(departments)

class TestSendEmail(unittest.TestCase):
    # 测试 创建成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_create(self, mock_send_post):
        memberApiClient.userCreate(user_create_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/create")
        self.assertEqual(request_param.data.name, name)
        self.assertEqual(request_param.data.username, user_name)

    # 测试 获取部门成员（递归）
    @patch.object(memberApiClient, 'send_post')
    def test_dept_member_list(self, mock_send_post):
        memberApiClient.deptMemberList(deptNo, True)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/user/list")
        self.assertEqual(request_param.data["dept_no"], deptNo)
        self.assertEqual(request_param.data["has_child"], True)

    # 测试 获取成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_info(self, mock_send_post):
        memberApiClient.userInfo(user_name)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/get")
        self.assertEqual(request_param.data["username"], user_name)

    # 测试 更新成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_update(self, mock_send_post):
        user_update_param = UserUpdateParam(name, user_name)
        user_update_param.setDepartments([101, 201])
        user_update_param.setName(name + '_update')
        memberApiClient.userUpdate(user_update_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/update")
        self.assertEqual(request_param.data["departments"], [101, 201])
        self.assertEqual(request_param.data["name"], name + '_update')
        self.assertEqual(request_param.data["username"], user_name)

    # 测试 删除成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_delete(self, mock_send_post):
        memberApiClient.userDelete(user_name)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/delete")
        self.assertEqual(request_param.data["username"], user_name)

    # 测试 批量导入成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_import(self, mock_send_post):
        user_create_param.setUsername(user_name + '_import')
        user_create_param.setName(user_name + '_import')
        memberApiClient.userImport([user_create_param])
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/import")
        self.assertEqual(request_param.data["users"][0].username, user_name + '_import')
        self.assertEqual(request_param.data["users"][0].name, user_name + '_import')

    # 测试 批量删除成员
    @patch.object(memberApiClient, 'send_post')
    def test_user_batch_delete(self, mock_send_post):
        memberApiClient.userBatchDelete([user_create_param.username])
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/user/batch_delete")
        self.assertEqual(request_param.data["usernames"], [user_create_param.username])