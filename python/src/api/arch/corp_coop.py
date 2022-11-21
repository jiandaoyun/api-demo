from ...util.http_util import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v4')
# 默认版本
default_version = 'v4'


class CorpCoopApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    '''
    列出我连接的企业
    Arguments:
        dept_no: integer 部门编号
    '''

    def corpCoopDepartList(self, dept_no, version):
        url = self.host + HttpConstant.CORP_COOP_URL.format(suffix='guest/department_list', version=self.getValidVersion(version))
        request_param = HttpRequestParam(self.api_key, url, {"dept_no": dept_no})
        return self.send_post(request_param)

    '''
    列出我连接的企业对接人
    Arguments:
        dept_no: integer 部门编号
        version: 版本
    '''

    def corpCoopMemberList(self, dept_no, version):
        url = self.host + HttpConstant.CORP_COOP_URL.format(suffix='guest/member_list', version=self.getValidVersion(version))
        request_param = HttpRequestParam(self.api_key, url, {"dept_no": dept_no})
        return self.send_post(request_param)

    '''
    列出我连接的企业对接人详细信息
    Arguments:
        user_name: str 用户名
        version: 版本
    '''

    def corpCoopUserInfo(self, user_name, version):
        url = self.host + HttpConstant.CORP_COOP_URL.format(suffix='guest/user_retrieve', version=self.getValidVersion(version))
        request_param = HttpRequestParam(self.api_key, url, {"username": user_name})
        return self.send_post(request_param)
