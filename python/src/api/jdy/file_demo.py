from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
获取文件上传凭证和上传地址接口
Arguments:
    work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
"""


def uploadToken(app_id, entry_id, transaction_id):
    url = HttpConstant.APP_BASE_URL + app_id + "/entry/" + entry_id + "/file/get_upload_token"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'transaction_id': transaction_id})
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
