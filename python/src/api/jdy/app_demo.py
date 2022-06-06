import src.util.http_util as http_util
from src.model.http.http_request_param import HttpRequestParam
from src.constants.http_constant import HttpConstant

"""
应用分页列表
Arguments:
    skip: int 跳过的数量
    limit: int 取多少数据
"""


def appList(skip, limit):
    url = HttpConstant.APP_BASE_URL + 'retrieve_all'
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
    url = HttpConstant.APP_BASE_URL + appId + "/entry_retrieve"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'skip': skip, 'limit': limit})
    return http_util.send_post(request_param)
