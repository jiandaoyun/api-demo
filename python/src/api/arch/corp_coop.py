from src.model.http.api_client import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class CorpCoopApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    '''
    列出我连接的企业
    Arguments:
        dept_no: integer 部门编号
        version: 版本
    '''

    def corpCoopDepartList(self, dept_no, version=default_version):
        path = HttpConstant.CORP_COOP_PATH.format(suffix='department/list',
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"dept_no": dept_no})
        return self.send_post(request_param)

    '''
    列出我连接的企业对接人
    Arguments:
        dept_no: integer 部门编号
        version: 版本
    '''

    def corpCoopMemberList(self, dept_no, version=default_version):
        path = HttpConstant.CORP_COOP_PATH.format(suffix='user/list',
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"dept_no": dept_no})
        return self.send_post(request_param)

    '''
    列出我连接的企业对接人详细信息
    Arguments:
        user_name: str 用户名
        version: 版本
    '''

    def corpCoopUserInfo(self, user_name, version=default_version):
        path = HttpConstant.CORP_COOP_PATH.format(suffix='user/get',
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"username": user_name})
        return self.send_post(request_param)
