from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from ...model.http.http_request_param import generateTransactionId
from src.model.http.api_client import ApiClient

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class FileApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    获取文件上传凭证和上传地址接口
    Arguments:  
        work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
    """

    def uploadToken(self, app_id, entry_id, version=default_version):
        path = HttpConstant.FORM_PATH.format(suffix='file/get_upload_token',
                                             version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'transaction_id': generateTransactionId(),
                                                'app_id': app_id,
                                                'entry_id': entry_id})
        return self.send_post(request_param)

    """
    上传文件
    Arguments:
        url: str 
        token: str
        file: 
    """

    def uploadFile(self, url, token, file):
        data = {'token': token}
        return self.send_post_with_file(url, data, file)
