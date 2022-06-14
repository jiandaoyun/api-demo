from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

'''
列出我连接的企业
Arguments:
    dept_no: integer 部门编号
'''


def corpCoopDepartList(dept_no):
    url = HttpConstant.CORP_COOP_URL.format(suffix='guest/department_list')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"dept_no": dept_no})
    return http_util.send_post(request_param)


'''
列出我连接的企业对接人
Arguments:
    dept_no: integer 部门编号
'''


def corpCoopMemberList(dept_no):
    url = HttpConstant.CORP_COOP_URL.format(suffix='guest/member_list')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"dept_no": dept_no})
    return http_util.send_post(request_param)


'''
列出我连接的企业对接人详细信息
Arguments:
    user_name: str 用户名
'''


def corpCoopUserInfo(user_name):
    url = HttpConstant.CORP_COOP_URL.format(suffix='guest/user_retrieve')
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"username": user_name})
    return http_util.send_post(request_param)
