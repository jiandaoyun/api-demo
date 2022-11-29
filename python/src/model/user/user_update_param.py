class UserUpdateParam:
    def __init__(self, name, user_name):
        self.name = name
        # 用户名 由数字字母和下划线组成
        self.username = user_name

    def setDepartments(self, departments):
        # 列表 int 选填
        self.departments = departments

    def getUserName(self):
        return self.username

    def getName(self):
        return self.name

    def getDepartments(self):
        return self.departments if hasattr(self, 'departments') else None

    def setName(self, name):
        self.name = name
