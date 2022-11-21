from src.api.arch.corp_coop_demo import CorpCoopApi
from src.constants.http_constant import HttpConstant

corpCoopApi = CorpCoopApi(HttpConstant.API_KEY,HttpConstant.HOST)


#  列出我连接的企业
def corpCoopDepartList():
    result = corpCoopApi.corpCoopDepartList(None, None)
    print('corpCoopDepartList result:', result)


#  列出我连接的企业对接人
def corpCoopMemberList():
    result = corpCoopApi.corpCoopMemberList(None, 'v4')
    print('corpCoopMemberList result:', result)


# 列出我连接的企业对接人详细信息
def corpCoopUserInfo():
    result = corpCoopApi.corpCoopUserInfo('R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg', 'v2')
    print('corpCoopUserInfo result:', result)


if __name__ == '__main__':
    corpCoopDepartList()
    corpCoopMemberList()
    corpCoopUserInfo()
