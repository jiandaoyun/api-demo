import unittest
from unittest.mock import patch
from src.model.dept.dept_create_param import DeptCreateParam
from src.constants.http_constant import HttpConstant
from src.api.arch.dept import DeptApiClient

deptApiClient = DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

deptName = 'python-v5-name-'
parentNo = 1
deptNo = 14329

class TestSendEmail(unittest.TestCase):
    #  测试创建部门
    @patch.object(deptApiClient, 'send_post')
    def test_dept_create(self, mock_send_post):
        dept_create_param = DeptCreateParam(deptName + str(deptNo))
        dept_create_param.setDeptNo(deptNo)
        dept_create_param.setParentNo(parentNo)
        deptApiClient.deptCreate(dept_create_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/create")
        self.assertEqual(request_param.data.name, deptName + str(deptNo))
        self.assertEqual(request_param.data.dept_no, deptNo)
        self.assertEqual(request_param.data.parent_no, parentNo)

    # 测试部门列表
    @patch.object(deptApiClient, 'send_post')
    def test_dept_list(self, mock_send_post):
        deptApiClient.deptList(deptNo, True)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/list")
        self.assertEqual(request_param.data["dept_no"], deptNo)
        self.assertEqual(request_param.data["has_child"], True)

    # 测试 更新部门
    @patch.object(deptApiClient, 'send_post')
    def test_dept_update(self, mock_send_post):
        deptApiClient.deptUpdate(deptNo, 'python-update')
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/update")
        self.assertEqual(request_param.data["dept_no"], deptNo)
        self.assertEqual(request_param.data["name"], 'python-update')

    # 根据部门编号 删除部门
    @patch.object(deptApiClient, 'send_post')
    def test_dept_delete(self, mock_send_post):
        deptApiClient.deptDelete(deptNo)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/delete")
        self.assertEqual(request_param.data["dept_no"], deptNo)

    # 测试 根据集成模式通讯录的部门ID获取部门编号
    @patch.object(deptApiClient, 'send_post')
    def test_dept_by_integrate_id(self, mock_send_post):
        deptApiClient.deptByIntegrateId('58335612')
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/dept_no/get")
        self.assertEqual(request_param.data["integrate_id"], '58335612')

    # 测试 批量导入部门
    @patch.object(deptApiClient, 'send_post')
    def test_dept_import(self, mock_send_post):
        departments = []
        deptOne = DeptCreateParam(deptName + '_one')
        deptOne.setParentNo(parentNo)
        deptOne.setDeptNo(parentNo + 100)
        departments.append(deptOne)
        deptTwo = DeptCreateParam(deptName + '_two')
        deptTwo.setDeptNo(parentNo + 200)
        deptTwo.setParentNo(parentNo)
        departments.append(deptTwo)
        deptApiClient.departmentImport(departments)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.path, "/v5/corp/department/import")
        self.assertEqual(request_param.data["departments"][0].name, deptName + '_one')
        self.assertEqual(request_param.data["departments"][0].parent_no, parentNo)
        self.assertEqual(request_param.data["departments"][0].dept_no, parentNo + 100)
        self.assertEqual(request_param.data["departments"][1].name, deptName + '_two')
        self.assertEqual(request_param.data["departments"][1].parent_no, parentNo)
        self.assertEqual(request_param.data["departments"][1].dept_no, parentNo + 200)