from src.model.http.api_client import ApiClient
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class RoleGroupApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
     列出角色组
     Arguments:
        role_list_query_param: RoleListQueryParam 实例
        version: 版本
    """

    def roleGroupList(self, role_group_list_query_param, version=default_version):
        path = HttpConstant.ROLE_GROUP_PATH.format(suffix='list', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, role_group_list_query_param)
        return self.send_post(request_param)

    """
    创建角色组
    Arguments:
        name: str 
        version: 版本
    """

    def roleGroupCreate(self, name, version=default_version):
        path = HttpConstant.ROLE_GROUP_PATH.format(suffix='create', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"name": name})
        return self.send_post(request_param)

    """
    修改角色组
    Arguments:
        name: str 
        role_group_no: int
        version: 版本
    """

    def roleGroupUpdate(self, name, role_group_no, version=default_version):
        path = HttpConstant.ROLE_GROUP_PATH.format(suffix='update', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"name": name, "role_group_no": role_group_no})
        return self.send_post(request_param)

    """
    删除角色组
    Arguments:
        role_group_no: int
        version: 版本
    """

    def roleGroupDelete(self, role_group_no, version=default_version):
        path = HttpConstant.ROLE_GROUP_PATH.format(suffix='delete', version=self.getValidVersion(version))
        request_param = HttpRequestParam(path, {"role_group_no": role_group_no})
        return self.send_post(request_param)
