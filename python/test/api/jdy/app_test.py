import unittest
from unittest.mock import patch
from src.constants.http_constant import HttpConstant
from src.api.jdy.app import AppApiClient

appApiClient = AppApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

class TestSendEmail(unittest.TestCase):
    # 测试 应用分页列表
    @patch.object(appApiClient, 'send_post')
    def test_app_list(self, mock_send_post):
        appApiClient.appList(0, 10)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data, {
            'skip': 0, 'limit': 10
        })
        self.assertEqual(request_param.path, "/v5/app/list")

    # 表单查询接口 分页
    @patch.object(appApiClient, 'send_post')
    def test_entry_list(self, mock_send_post):
        appApiClient.entryList(HttpConstant.APP_ID, 0, 10)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data, {
            'skip': 0, 'limit': 10, 'app_id': HttpConstant.APP_ID
        })
        self.assertEqual(request_param.path, "/v5/app/entry/list")
