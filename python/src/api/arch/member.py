from src.model.http.api_client import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class MemberApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
     获取部门成员（递归）
     Arguments:
        dept_no: int 部门编号
        hasChild: boolean 是否递归获取
        version: 版本
    """

    def deptMemberList(self, dept_no, has_child, version=default_version):
        path = HttpConstant.DEPT_PATH.format(suffix='user/list',
                                             version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"has_child": has_child, 'dept_no': dept_no})
        return self.send_post(request_param)

    """
    创建 成员
    Arguments:
        user_create_param: UserCreateParam class 对象
        version: 版本
    """

    def userCreate(self, user_create_param, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(suffix='create', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, user_create_param)
        return self.send_post(request_param)

    """
    根据成员名称 获取成员
    Arguments:
        user_name: string 用户名称
        version: 版本
    """

    def userInfo(self, user_name, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(version=self.getValidVersion(version),
                                               suffix='get')
        request_param = HttpRequestParam(path, {'username': user_name})
        return self.send_post(request_param)

    """
    更新成员
    Arguments:
        user_name: string 用户名称
        version: 版本
    """

    def userUpdate(self, user_update_param, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(version=self.getValidVersion(version), suffix='update')
        request_param = HttpRequestParam(path,
                                         {'name': user_update_param.getName(),
                                          'departments': user_update_param.getDepartments(),
                                          'username': user_update_param.getUserName()})
        return self.send_post(request_param)

    """
    删除 成员
    Arguments:
        user_name: string 用户名称
        version: 版本
    """

    def userDelete(self, user_name, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(version=self.getValidVersion(version),
                                               suffix='delete')
        request_param = HttpRequestParam(path, {'username': user_name})
        return self.send_post(request_param)

    """
    批量 删除 成员
    Arguments:
        user_name_list: list string 用户名称
        version: 版本
    """

    def userBatchDelete(self, user_name_list, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(suffix='batch_delete', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'usernames': user_name_list})
        return self.send_post(request_param)

    '''
    批量导入成员
    Arguments:
        users: list<DeptCreateParam>
        version: 版本
    '''

    def userImport(self, users, version=default_version):
        path = HttpConstant.MEMBER_PATH.format(suffix='import', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'users': users})
        return self.send_post(request_param)
