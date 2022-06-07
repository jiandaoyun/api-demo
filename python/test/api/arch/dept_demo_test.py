import src.api.arch.dept_demo as dept_demo
from src.model.dept.dept_create_param import DeptCreateParam


#  测试创建部门
def deptCreate():
    dept_create_param = DeptCreateParam('python-name17')
    dept_create_param.setDeptNo(311)
    dept_create_param.setParentNo(209)
    result = dept_demo.deptCreate(dept_create_param)
    print('dept_create result:', result)


# 测试部门列表
def deptList():
    result = dept_demo.deptList(209)
    print('deptList result:', result)


# 测试 更新部门
def deptUpdate():
    result = dept_demo.deptUpdate(188, 'python-name18')
    print('deptUpdate result:', result)


# 根据部门编号 删除部门
def deptDelete():
    result = dept_demo.deptDelete(188)
    print('deptDelete result:', result)


# 测试 根据集成模式通讯录的部门ID获取部门编号
def deptByIntegrateId():
    result = dept_demo.deptByIntegrateId('212')
    print('deptByIntegrateId result:', result)


if __name__ == '__main__':
    deptCreate()
    deptList()
    deptUpdate()
    deptDelete()
    deptByIntegrateId()
