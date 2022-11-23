from ...model.http.http_request_param import HttpRequestParam
from src.model.http.http_util import ApiClient
from ...constants.http_constant import HttpConstant

# 合法的版本
valid_versions = ('v1')
# 默认版本
default_version = 'v1'


class AppApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    应用分页列表
    Arguments:
        skip: int 跳过的数量
        limit: int 取多少数据
        version: 版本
    """

    def appList(self, skip, limit, version=default_version):
        path = HttpConstant.APP_PATH.format(suffix='retrieve_all', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'skip': skip, 'limit': limit})
        return self.send_post(request_param)

    """
    表单查询接口 分页
    Arguments:
        appId: string 应用id
        skip: int 跳过的数量
        limit: int 取多少数据
        version: 版本
    """

    def entryList(self, app_id, skip, limit, version=default_version):
        path = HttpConstant.ENTRY_LIST_PATH.format(app_id=app_id, version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'skip': skip, 'limit': limit})
        return self.send_post(request_param)
