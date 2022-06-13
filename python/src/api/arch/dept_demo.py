from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
创建 部门
Arguments:
    dept_create_param: DeptCreateParam class 对象
"""


def deptCreate(dept_create_param):
    url = HttpConstant.DEPT_BASE_URL + 'create'
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, dept_create_param)
    return http_util.send_post(request_param)


"""
获取部门编号对应部门列表 （递归）
Arguments:
    deptNo: int 部门编号
"""


def deptList(deptNo, has_child):
    url = HttpConstant.DEPT_BASE_URL + str(deptNo) + "/department_list"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"has_child": has_child})
    return http_util.send_post(request_param)


"""
根据部门编号 更新部门名称
Arguments:
    deptNo: int 部门编号
    name: sting 新的部门名称
"""


def deptUpdate(dept_no, name):
    url = HttpConstant.DEPT_BASE_URL + str(dept_no) + "/update"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"name": name})
    return http_util.send_post(request_param)


"""
根据部门编号 删除部门
Arguments:
    deptNo: int 部门编号
"""


def deptDelete(deptNo):
    url = HttpConstant.DEPT_BASE_URL + str(deptNo) + "/delete"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
    return http_util.send_post(request_param)


"""
根据集成模式通讯录的部门ID获取部门编号
Arguments:
    integrateId: string
"""


def deptByIntegrateId(integrateId):
    url = HttpConstant.DEPT_BASE_URL + "get_deptno_by_integrateid"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"integrate_id": integrateId})
    return http_util.send_post(request_param)


"""
批量导入部门
Arguments:
    departments: list<DeptCreateParam>
"""


def departmentImport(departments):
    url = HttpConstant.DEPT_BASE_URL + "import"
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"departments": departments})
    return http_util.send_post(request_param)
