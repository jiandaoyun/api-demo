from src.constants.http_constant import HttpConstant
from src.api.jdy.form import FormApiClient

formApiClient = FormApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


# 测试 表单字段查询接口
def formWidgets():
    result = formApiClient.formWidgets(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    print('formWidgets result:', result)


if __name__ == '__main__':
    formWidgets()
