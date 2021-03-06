from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam


"""
应用分页列表
Arguments:
    skip: int 跳过的数量
    limit: int 取多少数据
"""


def appList(skip, limit):
    url = HttpConstant.APP_URL.format(suffix='retrieve_all')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'skip': skip, 'limit': limit})
    return http_util.send_post(request_param)


"""
表单查询接口 分页
Arguments:
    appId: string 应用id
    skip: int 跳过的数量
    limit: int 取多少数据
"""


def entryList(appId, skip, limit):
    url = HttpConstant.ENTRY_LIST_URL.format(appId=appId)
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'skip': skip, 'limit': limit})
    return http_util.send_post(request_param)
