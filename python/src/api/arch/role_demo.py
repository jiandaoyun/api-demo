from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
 列出角色
 Arguments:
    role_list_query_param: RoleListQueryParam 实例
"""


def roleList(role_list_query_param):
    url = HttpConstant.ROLE_BASE_URL + "list"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, role_list_query_param)
    return http_util.send_post(request_param)


'''
创建角色
 Arguments:
    name: 角色名称 str
    group_no: int 角色组编号
'''


def roleCreate(name, group_no):
    url = HttpConstant.ROLE_BASE_URL + "create"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'name': name, 'group_no': group_no})
    return http_util.send_post(request_param)


'''
更新角色
 Arguments:
    name: 角色名称 str
    group_no: int 角色组编号
    role_no: int 角色编号
'''


def roleUpdate(name, group_no, role_no):
    url = HttpConstant.ROLE_BASE_URL + "update"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url,
                                     {'name': name, 'group_no': group_no, "role_no": role_no})
    return http_util.send_post(request_param)


'''
删除角色
 Arguments:
    role_no: int 角色编号
'''


def roleDelete(role_no):
    url = HttpConstant.ROLE_BASE_URL + "delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"role_no": role_no})
    return http_util.send_post(request_param)


'''
列出角色下的所有成员
 Arguments:
    role_no: int 角色编号
    skip: int
    limit: int
'''


def roleMemberList(role_no, skip, limit):
    url = HttpConstant.ROLE_BASE_URL + "member_list"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"role_no": role_no, "skip": skip, "limit": limit})
    return http_util.send_post(request_param)


'''
批量给已有的成员设置自建角色
 Arguments:
    role_no: int 角色编号
    usernames: list<str> 
'''


def roleAddMembers(role_no, usernames):
    url = HttpConstant.ROLE_BASE_URL + "add_members"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"role_no": role_no, "usernames": usernames})
    return http_util.send_post(request_param)

'''
为自建角色批量移除成员
 Arguments:
    role_no: int 角色编号
    usernames: list<str> 
'''


def roleRmoveMembers(role_no, usernames):
    url = HttpConstant.ROLE_BASE_URL + "remove_members"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"role_no": role_no, "usernames": usernames})
    return http_util.send_post(request_param)

