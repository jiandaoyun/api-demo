import src.api.arch.role_demo as role_demo
from src.model.role.role_list_query_param import RoleListQueryParam



# 测试 列出角色
def roleList():
    role_list_query_param = RoleListQueryParam(0, 10)
    result = role_demo.roleList(role_list_query_param)
    print('roleList result:', result)


# 测试 创建角色
def roleCreate():
    result = role_demo.roleCreate('python-name',2300)
    print('roleCreate result:', result)

# 测试 修改角色
def roleUpdate():
    result = role_demo.roleUpdate('python-name-1',2319,2329)
    print('roleUpdate result:', result)



# 测试 删除角色
def roleDelete():
    result = role_demo.roleDelete(2333)
    print('roleDelete result:', result)


# 测试 列出角色下的所有成员
def roleMemberList():
    result = role_demo.roleMemberList(2334,0,10)
    print('roleMemberList result:', result)


# 测试 批量给已有的成员设置自建角色
def roleAddMembers():
    result = role_demo.roleAddMembers(2334,['R-TygTJmwo','R-RS8aHUlr'])
    print('roleAddMembers result:', result)

#
# 测试 为自建角色批量移除成员
def roleRmoveMembers():
    result = role_demo.roleRmoveMembers(2334, ['R-TygTJmwo', 'R-RS8aHUlr'])
    print('roleRmoveMembers result:', result)


if __name__ == '__main__':
    roleCreate()
    roleList()
    roleUpdate()
    roleDelete()
    roleMemberList()
    roleAddMembers()
    roleRmoveMembers()


