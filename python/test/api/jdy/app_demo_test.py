import src.api.jdy.app_demo as app_demo


# 测试 应用分页列表
def appList():
    result = app_demo.appList(0, 10)
    print('appList result:', result)

# 表单查询接口 分页
def entryList():
    result = app_demo.entryList('60a4699d32b34f0006af96ec', 0, 10)
    print('entryList result:', result)


if __name__ == '__main__':
    appList()
    entryList()
