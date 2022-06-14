import src.api.jdy.file_demo as file_demo
from src.constants.http_constant import HttpConstant


# 测试 获取文件上传凭证和上传地址接口
def uploadToken():
    result = file_demo.uploadToken(HttpConstant.APP_ID, HttpConstant.ENTRY_ID, '87cd7d71-c6df-4281-9927-469094395678')
    # print('uploadToken result:', result)
    return result


def uploadFile(url, token):
    file = {'file': ('file_upload.txt', open('./file_upload.txt', 'rb'), 'application/txt')}
    result = file_demo.uploadFile(url, token, file)
    print('uploadFile result:', result)


if __name__ == '__main__':
    token_result = uploadToken()
    url = token_result['token_and_url_list'][0]['url']
    token = token_result['token_and_url_list'][0]['token']
    uploadFile(url, token)
