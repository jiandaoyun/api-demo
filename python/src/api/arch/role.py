from src.model.http.api_client import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class RoleApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
     列出角色
     Arguments:
        role_list_query_param: RoleListQueryParam 实例
        version: 版本
    """

    def roleList(self, role_list_query_param, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='list', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, role_list_query_param)
        return self.send_post(request_param)

    '''
    创建角色
     Arguments:
        name: 角色名称 str
        group_no: int 角色组编号
        version: 版本
    '''

    def roleCreate(self, name, group_no, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='create', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {'name': name, 'group_no': group_no})
        return self.send_post(request_param)

    '''
    更新角色
     Arguments:
        name: 角色名称 str
        group_no: int 角色组编号
        role_no: int 角色编号
        version: 版本
    '''

    def roleUpdate(self, name, group_no, role_no, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='update', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path,
                                         {'name': name, 'group_no': group_no, "role_no": role_no})
        return self.send_post(request_param)

    '''
    删除角色
     Arguments:
        role_no: int 角色编号
        version: 版本
    '''

    def roleDelete(self, role_no, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='delete', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"role_no": role_no})
        return self.send_post(request_param)

    '''
    列出角色下的所有成员
     Arguments:
        role_no: int 角色编号
        skip: int
        limit: int
        version: 版本
    '''

    def roleMemberList(self, role_no, skip, limit, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='user/list', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"role_no": role_no, "skip": skip, "limit": limit})
        return self.send_post(request_param)

    '''
    批量给已有的成员设置自建角色
     Arguments:
        role_no: int 角色编号
        usernames: list<str> 
        version: 版本
    '''

    def roleAddMembers(self, role_no, usernames, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='add_members', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"role_no": role_no, "usernames": usernames})
        return self.send_post(request_param)

    '''
    为自建角色批量移除成员
     Arguments:
        role_no: int 角色编号
        usernames: list<str> 
        version: 版本
    '''

    def roleRemoveMembers(self, role_no, usernames, version=default_version):
        path = HttpConstant.ROLE_PATH.format(suffix='remove_members', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"role_no": role_no, "usernames": usernames})
        return self.send_post(request_param)
