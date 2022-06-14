from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
 获取部门成员（递归）
 Arguments:
    deptNo: int 部门编号
    hasChild: boolean 是否递归获取
"""


def deptMemberList(deptNo, has_child):
    url = HttpConstant.DEPT_MEMBER_LIST_URL.format(deptNo=deptNo)
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"has_child": has_child})
    return http_util.send_post(request_param)


"""
创建 成员
Arguments:
    user_create_param: UserCreateParam class 对象
"""


def userCreate(user_create_param):
    url = HttpConstant.MEMBER_URL.format(suffix='create')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, user_create_param)
    return http_util.send_post(request_param)


"""
根据成员名称 获取成员
Arguments:
    userName: string 用户名称
"""


def userInfo(userName):
    url = HttpConstant.USER_INFO_URL.format(userName=userName)
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)


"""
更新成员
Arguments:
    user_name: string 用户名称
"""


def userUpdate(user_update_param):
    url = HttpConstant.USER_UPDATE_URL.format(userName=user_update_param.getUserName())

    request_param = HttpRequestParam(HttpConstant.API_KEY, url,
                                     {'name': user_update_param.getName(),
                                      'departments': user_update_param.getDepartments()})
    return http_util.send_post(request_param)


"""
删除 成员
Arguments:
    user_name: string 用户名称
"""


def userDelete(user_name):
    url = HttpConstant.USER_DELETE_URL.format(userName=user_name)
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)


"""
批量 删除 成员
Arguments:
    user_name_list: list string 用户名称
"""


def userBatchDelete(user_name_list):
    url = HttpConstant.MEMBER_URL.format(suffix='batch_delete')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'usernames': user_name_list})
    return http_util.send_post(request_param)


'''
批量导入成员
Arguments:
    users: list<DeptCreateParam>
'''


def userImport(users):
    url = HttpConstant.MEMBER_URL.format(suffix='import')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'users': users})
    return http_util.send_post(request_param)
