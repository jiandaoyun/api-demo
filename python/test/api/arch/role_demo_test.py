import src.api.arch.role_demo as role_demo
from src.model.role.role_list_query_param import RoleListQueryParam



# 测试 创建成员
def roleList():
    user_create_param = RoleListQueryParam(0, 10)
    result = role_demo.roleList(user_create_param)
    print('roleList result:', result)



if __name__ == '__main__':
    roleList()
