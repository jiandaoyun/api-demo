import src.api.arch.member_demo as member_demo
from src.model.dept.user_create_param import UserCreateParam
from src.model.dept.user_update_param import UserUpdateParam


# 测试 创建成员
def userCreate():
    user_create_param = UserCreateParam('python_name_6', 'python_username_6')
    departments = [213]
    user_create_param.setDepartments(departments)
    result = member_demo.userCreate(user_create_param)
    print('userCreate result:', result)


# 测试 获取部门成员（递归）
def deptMemberList():
    result = member_demo.deptMemberList(1, True)
    print('deptMemberList result:', result)


# 测试 获取部门成员（递归）
def userInfo():
    result = member_demo.userInfo('python_username_5')
    print('userInfo result:', result)


def userUpdate():
    user_update_param = UserUpdateParam('python_name_5', 'python_username_4')
    user_update_param.setDepartments([209])
    result = member_demo.userUpdate(user_update_param)
    print('userUpdate result:', result)


def userDelete():
    result = member_demo.userDelete('python_username_4')
    print('userDelete result:', result)


def userBatchDelete():
    result = member_demo.userBatchDelete(['python_username_6', 'python_username_5'])
    print('userDelete result:', result)

def userImport():
    result = member_demo.userImport(['python_username_6', 'python_username_5'])
    print('userImport result:', result)


if __name__ == '__main__':
    userCreate()
    deptMemberList()
    userInfo()
    userUpdate()
    userDelete()
    userBatchDelete()
    userImport()
