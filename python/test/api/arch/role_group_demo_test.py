import src.api.arch.role_group_demo as role_group_demo
from src.model.role.role_group_list_query_param import RoleGroupListQueryParam



# 测试 列出角色组
def roleGroupList():
    role_group_list_query_param = RoleGroupListQueryParam(0, 10)
    result = role_group_demo.roleGroupList(role_group_list_query_param)
    print('roleGroupList result:', result)

# 测试 创建角色组
def roleGroupCreate():
    result = role_group_demo.roleGroupCreate('python-name')
    print('roleGroupCreate result:', result)

# 测试更新角色组
def roleGroupUpdate():
    result = role_group_demo.roleGroupUpdate('python-name1',2335)
    print('roleGroupUpdate result:', result)


def roleGroupDelete():
    result = role_group_demo.roleGroupDelete(2335)
    print('roleGroupDelete result:', result)


if __name__ == '__main__':
    roleGroupCreate()
    roleGroupList()
    roleGroupUpdate()
    roleGroupDelete()


