from ...util.http_util import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v2', 'v1')
# 默认版本
default_version = 'v2'


class DeptApiClient(ApiClient):
    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    创建 部门
    Arguments:
        dept_create_param: DeptCreateParam class 对象
        version: 版本
    """

    def deptCreate(self, dept_create_param, version=default_version):
        url = HttpConstant.DEPT_URL.format(suffix='create',
                                           version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, dept_create_param)
        return self.send_post(request_param)

    """
    获取部门编号对应部门列表 （递归）
    Arguments:
        deptNo: int 部门编号
        version: 版本
    """

    def deptList(self, deptNo, has_child, version=default_version):
        url = HttpConstant.DEPT_LIST_URL.format(deptNo=deptNo,
                                                version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"has_child": has_child})
        return self.send_post(request_param)

    """
    根据部门编号 更新部门名称
    Arguments:
        deptNo: int 部门编号
        name: sting 新的部门名称
        version: 版本
    """

    def deptUpdate(self, deptNo, name, version=default_version):
        url = HttpConstant.UPDATE_DEPT_URL.format(deptNo=deptNo,
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"name": name})
        return self.send_post(request_param)

    """
    根据部门编号 删除部门
    Arguments:
        deptNo: int 部门编号
        version: 版本
    """

    def deptDelete(self, deptNo, version=default_version):
        url = HttpConstant.DELETE_DEPT_URL.format(deptNo=deptNo,
                                                  version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, None)
        return self.send_post(request_param)

    """
    根据集成模式通讯录的部门ID获取部门编号
    Arguments:
        integrateId: string
        version: 版本
    """

    def deptByIntegrateId(self, integrateId, version=default_version):
        url = HttpConstant.DEPT_URL.format(suffix='get_deptno_by_integrateid',
                                           version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"integrate_id": integrateId})
        return self.send_post(request_param)

    """
    批量导入部门
    Arguments:
        departments: list<DeptCreateParam>
        version: 版本
    """

    def departmentImport(self, departments, version=default_version):
        url = HttpConstant.DEPT_URL.format(suffix='import',
                                           version=self.getValidVersion(version))
        request_param = HttpRequestParam(HttpConstant.API_KEY, url, {"departments": departments})
        return self.send_post(request_param)
