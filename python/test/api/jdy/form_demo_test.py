import src.api.jdy.form_demo as form_demo
from src.constants.http_constant import HttpConstant




# 测试 表单字段查询接口
def formWidgets():
    result = form_demo.formWidgets(HttpConstant.APP_ID,HttpConstant.ENTRY_ID)
    print('formWidgets result:', result)

if __name__ == '__main__':
    formWidgets()


