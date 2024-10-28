import unittest
from unittest.mock import patch
from src.constants.http_constant import HttpConstant
from src.api.jdy.form import FormApiClient

formApiClient = FormApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


class TestSendEmail(unittest.TestCase):
    # 测试 表单字段查询接口
    @patch.object(formApiClient, 'send_post')
    def test_form_widgets(self, mock_send_post):
        formApiClient.formWidgets(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data, {
            'app_id': HttpConstant.APP_ID, 'entry_id': HttpConstant.ENTRY_ID
        })
        self.assertEqual(request_param.path, "/v5/app/entry/widget/list")
