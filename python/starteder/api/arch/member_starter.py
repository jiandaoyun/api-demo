from src.model.user.user_create_param import UserCreateParam
from src.model.user.user_update_param import UserUpdateParam
from src.api.arch.member import MemberApiClient
from src.constants.http_constant import HttpConstant
import random

memberApiClient = MemberApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

random = str(random.randint(100, 200))
name = 'name' + random
user_name = 'user_name' + random

deptNo = 1

user_create_param = UserCreateParam(name, user_name)
departments = [deptNo]
user_create_param.setDepartments(departments)


# 测试 创建成员
def userCreate():
    result = memberApiClient.userCreate(user_create_param)
    print('userCreate result:', result)


# 测试 获取部门成员（递归）
def deptMemberList():
    result = memberApiClient.deptMemberList(deptNo, True)
    print('deptMemberList result:', result)


# 测试 获取部门成员（递归）
def userInfo():
    result = memberApiClient.userInfo(user_name)
    print('userInfo result:', result)


def userUpdate():
    user_update_param = UserUpdateParam(name, user_name)
    user_update_param.setDepartments([101, 201])
    user_update_param.setName(name + '_update')
    result = memberApiClient.userUpdate(user_update_param)
    print('userUpdate result:', result)


def userDelete():
    result = memberApiClient.userDelete(user_name)
    print('userDelete result:', result)


def userImport():
    user_create_param.setUsername(user_name + '_import')
    user_create_param.setName(user_name + '_import')
    result = memberApiClient.userImport([user_create_param])
    print('userImport result:', result)


def userBatchDelete():
    result = memberApiClient.userBatchDelete([user_create_param.username])
    print('userDelete result:', result)


if __name__ == '__main__':
    userCreate()
    deptMemberList()
    userInfo()
    userUpdate()
    userDelete()
    userImport()
    userBatchDelete()
