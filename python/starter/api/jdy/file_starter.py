import src.api.jdy.file as file_demo
from src.constants.http_constant import HttpConstant
from src.api.jdy.file import FileApiClient

fileApiDemo = FileApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


# 测试 获取文件上传凭证和上传地址接口
def uploadToken():
    result = fileApiDemo.uploadToken(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    print('uploadToken result:', result)
    return result


def uploadFile(url, token):
    file = {'file': ('file_upload.txt', open('./file_upload.txt', 'rb'), 'application/txt')}
    result = fileApiDemo.uploadFile(url, token, file)
    print('uploadFile result:', result)


if __name__ == '__main__':
    token_result = uploadToken()
    url = token_result['token_and_url_list'][0]['url']
    token = token_result['token_and_url_list'][0]['token']
    uploadFile(url, token)
