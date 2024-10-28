from src.model.role.role_list_query_param import RoleListQueryParam
from src.api.arch.role import RoleApiClient
from src.constants.http_constant import HttpConstant

roleApiClient = RoleApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

group_no = 120
role_name = 'role_name' + str(group_no)

role_no = 0
user_names = ['R-gDIIDws8']


# 测试 列出角色
def roleList():
    role_list_query_param = RoleListQueryParam(0, 10)
    result = roleApiClient.roleList(role_list_query_param)
    print('roleList result:', result)


# 测试 创建角色
def roleCreate():
    result = roleApiClient.roleCreate(role_name, group_no)
    print('roleCreate result:', result)
    return result


# 测试 修改角色
def roleUpdate():
    result = roleApiClient.roleUpdate(role_name + '_update', group_no, role_no)
    print('roleUpdate result:', result)


# 测试 删除角色
def roleDelete():
    result = roleApiClient.roleDelete(role_no)
    print('roleDelete result:', result)


# 测试 批量给已有的成员设置自建角色
def roleAddMembers():
    result = roleApiClient.roleAddMembers(role_no, user_names)
    print('roleAddMembers result:', result)


# 测试 列出角色下的所有成员
def roleMemberList():
    result = roleApiClient.roleMemberList(role_no, 0, 10)
    print('roleMemberList result:', result)


# 测试 为自建角色批量移除成员
def roleRemoveMembers():
    result = roleApiClient.roleRemoveMembers(role_no, user_names)
    print('roleRemoveMembers result:', result)


if __name__ == '__main__':
    role = roleCreate()
    role_no = role['role']['role_no']
    roleList()
    roleUpdate()
    roleAddMembers()
    roleMemberList()
    roleRemoveMembers()
    roleDelete()
