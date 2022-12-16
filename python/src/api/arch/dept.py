from src.model.http.api_client import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


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
        path = HttpConstant.DEPT_PATH.format(suffix='create',
                                             version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, dept_create_param)
        return self.send_post(request_param)

    """
    获取部门编号对应部门列表 （递归）
    Arguments:
        dept_no: int 部门编号
        version: 版本
    """

    def deptList(self, dept_no, has_child, version=default_version):
        url = HttpConstant.DEPT_PATH.format(version=self.getValidVersion(version), suffix='list')
        request_param = HttpRequestParam(url, {"has_child": has_child, 'dept_no': dept_no})
        return self.send_post(request_param)

    """
    根据部门编号 更新部门名称
    Arguments:
        dept_no: int 部门编号
        name: sting 新的部门名称
        version: 版本
    """

    def deptUpdate(self, dept_no, name, version=default_version):
        url = HttpConstant.DEPT_PATH.format(version=self.getValidVersion(version), suffix='update')
        request_param = HttpRequestParam(url, {"name": name, 'dept_no': dept_no})
        return self.send_post(request_param)

    """
    根据部门编号 删除部门
    Arguments:
        dept_no: int 部门编号
        version: 版本
    """

    def deptDelete(self, dept_no, version=default_version):
        url = HttpConstant.DEPT_PATH.format(version=self.getValidVersion(version), suffix='delete')
        request_param = HttpRequestParam(url, {'dept_no': dept_no})
        return self.send_post(request_param)

    """
    根据集成模式通讯录的部门ID获取部门编号
    Arguments:
        integrate_id: string
        version: 版本
    """

    def deptByIntegrateId(self, integrate_id, version=default_version):
        url = HttpConstant.DEPT_PATH.format(suffix='dept_no/get',
                                            version=self.getValidVersion(version))
        request_param = HttpRequestParam(url, {"integrate_id": integrate_id})
        return self.send_post(request_param)

    """
    批量导入部门
    Arguments:
        departments: list<DeptCreateParam>
        version: 版本
    """

    def departmentImport(self, departments, version=default_version):
        url = HttpConstant.DEPT_PATH.format(suffix='import',
                                            version=self.getValidVersion(version))
        request_param = HttpRequestParam(url, {"departments": departments})
        return self.send_post(request_param)
