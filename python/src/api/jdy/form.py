from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from src.model.http.api_client import ApiClient

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class FormApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    表单字段查询接口
    Arguments:
        app_id: str 应用·id
        entry_id: str 表单id
        version: 版本
    """

    def formWidgets(self, app_id, entry_id, version=default_version):
        path = HttpConstant.FORM_PATH.format(suffix='widget/list',
                                             version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'app_id': app_id, 'entry_id': entry_id})
        return self.send_post(request_param)
