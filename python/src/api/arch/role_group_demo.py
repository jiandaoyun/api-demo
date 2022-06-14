from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
 列出角色组
 Arguments:
    role_list_query_param: RoleListQueryParam 实例
"""


def roleGroupList(role_group_list_query_param):
    url = HttpConstant.ROLE_GROUP_URL.format(suffix='list')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, role_group_list_query_param)
    return http_util.send_post(request_param)


"""
创建角色组
Arguments:
    name: str 
"""


def roleGroupCreate(name):
    url = HttpConstant.ROLE_GROUP_URL.format(suffix='create')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"name": name})
    return http_util.send_post(request_param)


"""
修改角色组
Arguments:
    name: str 
    role_group_no: int
"""


def roleGroupUpdate(name, role_group_no):
    url = HttpConstant.ROLE_GROUP_URL.format(suffix='update')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"name": name, "role_group_no": role_group_no})
    return http_util.send_post(request_param)


"""
删除角色组
Arguments:
    role_group_no: int
"""


def roleGroupDelete(role_group_no):
    url = HttpConstant.ROLE_GROUP_URL.format(suffix='delete')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"role_group_no": role_group_no})
    return http_util.send_post(request_param)
