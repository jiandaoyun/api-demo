class DeptCreateParam:
    def __init__(self, name):
        self.name = name

    def setParentNo(self, parent_no):
        # int 类型 选填
        self.parent_no = int(parent_no)

    def setDeptNo(self, dept_no):
        # int 类型 选填
        self.dept_no = int(dept_no)
