from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from ...model.http.http_request_param import generateTransactionId
from ...util.http_util import ApiClient

# 合法的版本
valid_versions = ('v1')
# 默认版本
default_version = 'v1'


class FileApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    获取文件上传凭证和上传地址接口
    Arguments:
        work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
    """

    def uploadToken(self, app_id, entry_id, version=default_version):
        url = HttpConstant.FILE_UPLOAD_URL.format(app_id=app_id, entry_id=entry_id,
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, generateTransactionId())
        return self.send_post(request_param)

    """
    上传文件
    Arguments:
        url: str 
        token: str
        file: 
    """

    def uploadFile(self, url, token, file, version=default_version):
        data = {'token': token}
        return self.send_post_with_file(url, data, file)
