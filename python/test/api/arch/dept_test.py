from src.model.dept.dept_create_param import DeptCreateParam
from src.constants.http_constant import HttpConstant
from src.api.arch.dept_demo import DeptApiClient

deptApiClient = DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


parentNo = 1
deptNo = 14321

#  测试创建部门
def deptCreate():
    dept_create_param = DeptCreateParam('python-v5-name-'+str(deptNo))
    dept_create_param.setDeptNo(deptNo)
    dept_create_param.setParentNo(parentNo)
    result = deptApiClient.deptCreate(dept_create_param, 'v2')
    print('dept_create result:', result)


# 测试部门列表
def deptList():
    result = deptApiClient.deptList(parentNo, True, 'v2')
    print('deptList result:', result)


# 测试 更新部门
def deptUpdate():
    result = deptApiClient.deptUpdate(deptNo, 'python-name18','v2')
    print('deptUpdate result:', result)


# 根据部门编号 删除部门
def deptDelete():
    result = deptApiClient.deptDelete(deptNo,'v2')
    print('deptDelete result:', result)


# 测试 根据集成模式通讯录的部门ID获取部门编号
def deptByIntegrateId():
    result = deptApiClient.deptByIntegrateId('135813157','v2')
    print('deptByIntegrateId result:', result)


# 测试 批量导入部门
def departmentImport():
    departments = []
    deptOne = DeptCreateParam('python-dept-one')
    deptOne.setParentNo(parentNo)
    deptOne.setDeptNo(parentNo+100)
    departments.append(deptOne)

    deptTwo = DeptCreateParam('python-dept-two')
    deptTwo.setDeptNo(parentNo+200)
    deptTwo.setParentNo(parentNo)
    departments.append(deptTwo)

    result = deptApiClient.departmentImport(departments,'v2')
    print('departmentImport result:', result)


if __name__ == '__main__':
    deptCreate()
    deptList()
    deptUpdate()
    deptDelete()
    deptByIntegrateId()
    departmentImport()
