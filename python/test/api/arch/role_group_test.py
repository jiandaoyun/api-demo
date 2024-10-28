import unittest
from unittest.mock import patch
from src.model.role.role_group_list_query_param import RoleGroupListQueryParam
from src.api.arch.role_group import RoleGroupApiClient
from src.constants.http_constant import HttpConstant

roleGroupApiClient = RoleGroupApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

role_group_name = 'role_group_name'
role_group_no = 0

class TestSendEmail(unittest.TestCase):
    # 测试 列出角色组
    @patch.object(roleGroupApiClient, 'send_post')
    def test_group_list(self, mock_send_post):
        role_group_list_query_param = RoleGroupListQueryParam(0, 10)
        roleGroupApiClient.roleGroupList(role_group_list_query_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role_group/list")
        self.assertEqual(request_param.data.skip, 0)
        self.assertEqual(request_param.data.limit, 10)

    # 测试 创建角色组
    @patch.object(roleGroupApiClient, 'send_post')
    def test_group_create(self, mock_send_post):
        roleGroupApiClient.roleGroupCreate(role_group_name)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role_group/create")
        self.assertEqual(request_param.data["name"], role_group_name)

    # 测试 更新角色组
    @patch.object(roleGroupApiClient, 'send_post')
    def test_group_update(self, mock_send_post):
        roleGroupApiClient.roleGroupUpdate(role_group_name + '_update', role_group_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role_group/update")
        self.assertEqual(request_param.data["name"], role_group_name + '_update')
        self.assertEqual(request_param.data["role_group_no"], role_group_no)

    # 测试 删除角色组
    @patch.object(roleGroupApiClient, 'send_post')
    def test_group_delete(self, mock_send_post):
        roleGroupApiClient.roleGroupDelete(role_group_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/role_group/delete")
        self.assertEqual(request_param.data["role_group_no"], role_group_no)