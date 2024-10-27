import unittest
from unittest.mock import patch
from src.api.arch.corp_coop import CorpCoopApiClient
from src.constants.http_constant import HttpConstant

dept_no = 6
corpCoopApiClient = CorpCoopApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

class TestSendEmail(unittest.TestCase):
    #  列出我连接的企业
    @patch.object(corpCoopApiClient, 'send_post')
    def test_corp_coop_depart_list(self, mock_send_post):
        corpCoopApiClient.corpCoopDepartList(dept_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/guest/department/list")
        self.assertEqual(request_param.data["dept_no"], dept_no)

    #  列出我连接的企业对接人
    @patch.object(corpCoopApiClient, 'send_post')
    def test_corp_coop_member_list(self, mock_send_post):
        corpCoopApiClient.corpCoopMemberList(dept_no)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/guest/user/list")
        self.assertEqual(request_param.data["dept_no"], dept_no)

    # 列出我连接的企业对接人详细信息
    @patch.object(corpCoopApiClient, 'send_post')
    def test_corp_coop_user_info(self, mock_send_post):
        corpCoopApiClient.corpCoopUserInfo('R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg')
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/guest/user/get")
        self.assertEqual(request_param.data["username"], 'R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg')