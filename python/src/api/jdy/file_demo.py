from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from ...model.http.http_request_param import generateTransactionId

"""
获取文件上传凭证和上传地址接口
Arguments:
    work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
"""


def uploadToken(app_id, entry_id):
    url = HttpConstant.FILE_UPLOAD_URL.format(app_id=app_id, entry_id=entry_id)
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, generateTransactionId())
    return http_util.send_post(request_param)


"""
上传文件
Arguments:
    url: str 
    token: str
    file: 
"""


def uploadFile(url, token, file):
    data = {'token': token}
    return http_util.send_post_with_file(url, data, file)
