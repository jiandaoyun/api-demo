from src.model.role.role_group_list_query_param import RoleGroupListQueryParam
from src.api.arch.role_group import RoleGroupApiClient
from src.constants.http_constant import HttpConstant

roleGroupApiClient = RoleGroupApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

role_group_name = 'role_group_name'
role_group_no = 0


# 测试 列出角色组
def roleGroupList():
    role_group_list_query_param = RoleGroupListQueryParam(0, 10)
    result = roleGroupApiClient.roleGroupList(role_group_list_query_param)
    print('roleGroupList result:', result)


# 测试 创建角色组
def roleGroupCreate():
    result = roleGroupApiClient.roleGroupCreate(role_group_name)
    print('roleGroupCreate result:', result)
    return result


# 测试更新角色组
def roleGroupUpdate():
    result = roleGroupApiClient.roleGroupUpdate(role_group_name + '_update', role_group_no)
    print('roleGroupUpdate result:', result)


def roleGroupDelete():
    result = roleGroupApiClient.roleGroupDelete(role_group_no)
    print('roleGroupDelete result:', result)


if __name__ == '__main__':
    role_group = roleGroupCreate()
    role_group_no = role_group['role_group']['group_no']
    roleGroupList()
    roleGroupUpdate()
    roleGroupDelete()
