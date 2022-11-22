from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from ...util.http_util import ApiClient

# 合法的版本
valid_versions = ('v2', 'v1')
# 默认版本
default_version = 'v2'


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
        url = HttpConstant.FORM_WIDGETS_URL.format(app_id=app_id, entry_id=entry_id,
                                                   version=self.getValidVersion(version))
        request_param = HttpRequestParam( url, None)
        return self.send_post(request_param)
