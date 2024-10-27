from src.constants.http_constant import HttpConstant
from src.api.jdy.app import AppApiClient

appApiCilent = AppApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


# 测试 应用分页列表
def appList():
    result = appApiCilent.appList(0, 10)
    print('appList result:', result)


# 表单查询接口 分页
def entryList():
    result = appApiCilent.entryList(HttpConstant.APP_ID, 0, 10)
    print('entryList result:', result)


if __name__ == '__main__':
    appList()
    entryList()
