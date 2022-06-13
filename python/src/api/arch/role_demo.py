from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam



"""
 获取部门成员（递归）
 Arguments:
    deptNo: int 部门编号
    hasChild: boolean 是否递归获取
"""


def roleList(role_list_query_param):
    url = HttpConstant.DEPT_BASE_URL + "list"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, role_list_query_param)
    return http_util.send_post(request_param)




"""
创建 成员
Arguments:
    user_create_param: UserCreateParam class 对象
"""


def userCreate(user_create_param):
    url = HttpConstant.MEMBER_BASE_URL + 'create'
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, user_create_param)
    return http_util.send_post(request_param)


"""
根据成员名称 获取成员
Arguments:
    user_name: string 用户名称
"""


def userInfo(user_name):
    url = HttpConstant.MEMBER_BASE_URL + user_name + "/user_retrieve"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)


"""
更新成员
Arguments:
    user_name: string 用户名称
"""


def userUpdate(user_update_param):
    url = HttpConstant.MEMBER_BASE_URL + user_update_param.getUserName() + "/update"
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
    url = HttpConstant.MEMBER_BASE_URL + user_name + "/delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)


"""
批量 删除 成员
Arguments:
    user_name_list: list string 用户名称
"""


def userBatchDelete(user_name_list):
    url = HttpConstant.MEMBER_BASE_URL + "batch_delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'usernames': user_name_list})
    return http_util.send_post(request_param)


'''
批量导入成员
Arguments:
    users: list<DeptCreateParam>
'''


def userImport(users):
    url = HttpConstant.MEMBER_BASE_URL + "import"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {'users': users})
    return http_util.send_post(request_param)