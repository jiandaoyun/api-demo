import unittest
from unittest.mock import patch
from src.model.role.role_list_query_param import RoleListQueryParam
from src.api.arch.role import RoleApiClient
from src.constants.http_constant import HttpConstant

roleApiClient = RoleApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

group_no = 120
role_name = 'role_name' + str(group_no)

role_no = 0
user_names = ['R-gDIIDws8']

class TestSendEmail(unittest.TestCase):
    # 测试 列出角色
    @patch.object(roleApiClient, 'send_post')
    def test_role_lost(self, mock_send_post):
        role_list_query_param = RoleListQueryParam(0, 10)
        roleApiClient.roleList(role_list_query_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/list")
        self.assertEqual(request_param.data.skip, 0)
        self.assertEqual(request_param.data.limit, 10)

    # 测试 创建角色
    @patch.object(roleApiClient, 'send_post')
    def test_role_create(self, mock_send_post):
        roleApiClient.roleCreate(role_name, group_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/create")
        self.assertEqual(request_param.data["name"], role_name)
        self.assertEqual(request_param.data["group_no"], group_no)

    # 测试 修改角色
    @patch.object(roleApiClient, 'send_post')
    def test_role_update(self, mock_send_post):
        roleApiClient.roleUpdate(role_name + '_update', group_no, role_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/update")
        self.assertEqual(request_param.data["name"], role_name+ '_update')
        self.assertEqual(request_param.data["group_no"], group_no)
        self.assertEqual(request_param.data["role_no"], role_no)

    # 测试 删除角色
    @patch.object(roleApiClient, 'send_post')
    def test_role_delete(self, mock_send_post):
        roleApiClient.roleDelete(role_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/delete")
        self.assertEqual(request_param.data["role_no"], role_no)

    # 测试 批量给已有的成员设置自建角色
    @patch.object(roleApiClient, 'send_post')
    def test_role_add_members(self, mock_send_post):
        roleApiClient.roleAddMembers(role_no, user_names)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/add_members")
        self.assertEqual(request_param.data["role_no"], role_no)
        self.assertEqual(request_param.data["usernames"], user_names)

    # 测试 列出角色下的所有成员
    @patch.object(roleApiClient, 'send_post')
    def test_role_member_list(self, mock_send_post):
        roleApiClient.roleMemberList(role_no, 0, 10)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/user/list")
        self.assertEqual(request_param.data["role_no"], role_no)
        self.assertEqual(request_param.data["skip"], 0)
        self.assertEqual(request_param.data["limit"], 10)

    # 测试 为自建角色批量移除成员
    @patch.object(roleApiClient, 'send_post')
    def test_role_remove_members(self, mock_send_post):
        roleApiClient.roleRemoveMembers(role_no, user_names)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role/remove_members")
        self.assertEqual(request_param.data["role_no"], role_no)
        self.assertEqual(request_param.data["usernames"], user_names)