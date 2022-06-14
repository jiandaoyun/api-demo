from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
新建单条数据接口
Arguments:
    param: FormDataCreateParam 实例
"""


def singleDataCreate(param):
    url = HttpConstant.FORM_DATA_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data_create"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)


"""
查询单条数据接口
Arguments:
    appId: str 应用id
    entry_id: str 表单id
    data_id: str 数据id
"""


def singleDataQuery(app_id, entry_id, data_id):
    url = HttpConstant.FORM_DATA_BASE_URL + app_id + "/entry/" + entry_id + "/data_retrieve"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'data_id': data_id})
    return http_util.send_post(request_param)


"""
修改单条数据接口
Arguments:
    param: FormDataUpdateParam 实例
"""


def singleDataUpdate(param):
    url = HttpConstant.FORM_DATA_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data_update"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)


"""
刪除单条数据接口
Arguments:
    param: FormDataDeleteParam 实例
"""


def singleDataRemove(param):
    url = HttpConstant.APP_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data_delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)


"""
新建多条数据接口
Arguments:
    param: FormDataBatchCreateParam 实例
"""


def batchDataCreate(param):
    url = HttpConstant.APP_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data_batch_create"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)


"""
查询多条数据接口
Arguments:
    param: FormDataQueryParam 实例
"""


def batchDataQuery(param):
    url = HttpConstant.APP_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)


"""
删除多条数据接口
Arguments:
    appId: str 应用id
    entry_id: str 表单id
    data_ids: list<str> 数据id list
"""


def batchDataRemove(app_id, entry_id, data_ids):
    url = HttpConstant.APP_BASE_URL + app_id + "/entry/" + entry_id + "/data_batch_delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'data_ids': data_ids})
    return http_util.send_post(request_param)


"""
修改多条数据接口
Arguments:
    param:FormDataBatchUpdateParam 实例
"""


def batchDataUpdate(param):
    url = HttpConstant.APP_BASE_URL + param.app_id + "/entry/" + param.entry_id + "/data_batch_update"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, param)
    return http_util.send_post(request_param)



