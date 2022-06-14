from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
表单字段查询接口
Arguments:
    appId: str 应用·id
    entryId: str 表单id
"""


def formWidgets(appId, entryId):
    url = HttpConstant.FORM_BASE_URL + appId + "/entry/" + entryId + "/widgets"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)

