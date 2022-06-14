import src.api.arch.corp_coop_demo as corp_coop_demo


#  列出我连接的企业
def corpCoopDepartList():
    result = corp_coop_demo.corpCoopDepartList(None)
    print('corpCoopDepartList result:', result)


#  列出我连接的企业对接人
def corpCoopMemberList():
    result = corp_coop_demo.corpCoopMemberList(None)
    print('corpCoopMemberList result:', result)


# 列出我连接的企业对接人详细信息
def corpCoopUserInfo():
    result = corp_coop_demo.corpCoopUserInfo('R-61150d0d497d9f0006448073-jdy-pr55od7jrsl7')
    print('corpCoopUserInfo result:', result)


if __name__ == '__main__':
    corpCoopDepartList()
    corpCoopMemberList()
    corpCoopUserInfo()
