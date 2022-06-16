import src.api.jdy.app_demo as app_demo
from src.constants.http_constant import HttpConstant


# 测试 应用分页列表
def appList():
    result = app_demo.appList(0, 10)
    print('appList result:', result)


# 表单查询接口 分页
def entryList():
    result = app_demo.entryList(HttpConstant.APP_ID, 0, 10)
    print('entryList result:', result)


if __name__ == '__main__':
    appList()
    entryList()
