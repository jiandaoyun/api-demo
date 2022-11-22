from src.api.arch.corp_coop import CorpCoopApiClient
from src.constants.http_constant import HttpConstant

corpCoopApiClient = CorpCoopApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


#  列出我连接的企业
def corpCoopDepartList():
    result = corpCoopApiClient.corpCoopDepartList(None)
    print('corpCoopDepartList result:', result)


#  列出我连接的企业对接人
def corpCoopMemberList():
    result = corpCoopApiClient.corpCoopMemberList(None)
    print('corpCoopMemberList result:', result)


# 列出我连接的企业对接人详细信息
def corpCoopUserInfo():
    result = corpCoopApiClient.corpCoopUserInfo('R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg')
    print('corpCoopUserInfo result:', result)


if __name__ == '__main__':
    corpCoopDepartList()
    corpCoopMemberList()
    corpCoopUserInfo()
