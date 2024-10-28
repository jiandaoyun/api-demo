import unittest
from unittest.mock import patch
from src.constants.http_constant import HttpConstant
from src.api.jdy.file import FileApiClient

fileApiClient = FileApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

class TestSendEmail(unittest.TestCase):
    # 测试 获取文件上传凭证和上传地址接口
    @patch.object(fileApiClient, 'send_post')
    def test_upload_token(self, mock_send_post):
        fileApiClient.uploadToken(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data["app_id"], HttpConstant.APP_ID)
        self.assertEqual(request_param.data["entry_id"], HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/file/get_upload_token")
