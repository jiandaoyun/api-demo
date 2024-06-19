import requests
import json
from src.util.limit_util import Limiter
import threading
from src.util.encoder_util import MyEncoder

limiter = Limiter(1000, 5)

lock = threading.Lock()


class ApiClient:

    def __init__(self, api_key, host, valid_versions, default_version):
        self.api_key = api_key
        self.host = host
        self.valid_versions = valid_versions
        self.default_version = default_version

    """ 
    返回合法的版本
    """

    def getValidVersion(self, version):
        if isinstance(version, str) and version in self.valid_versions:
            return version
        return self.default_version

    """ 
    返回带有认证信息的请求头
    """

    @staticmethod
    def get_req_header(api_key):
        return {
            'Authorization': 'Bearer ' + api_key,
            'Content-Type': 'application/json;charset=utf-8'
        }

    """
    发送 post 请求
    Arguments:
        request_param: HttpRequestParam class 实例
    """

    def send_post(self, request_param):
        headers = self.get_req_header(self.api_key)
        data = None
        url = self.host + request_param.path
        # 如果有 data 的话 把 data 序列化
        if request_param.data:
            if isinstance(request_param.data, dict):
                data = json.dumps(request_param.data, cls=MyEncoder)
            else:
                data = json.dumps(request_param.data.__dict__)
        try:
            # 限流
            lock.acquire()
            limiter.tryBeforeRun()
            # 这里传入的data,是body里面的数据。params是拼接url时的参数
            res = requests.post(url=url, data=data, headers=headers)
            return self.handle_result(res)
        finally:
            lock.release()

    # 处理请求返回的结果
    def handle_result(self, res):
        if res.status_code >= 400:
            raise Exception('Opps，Something Wrong: ', res.text)
        else:
            return "success" if len(res.text) == 0 else res.json()

    def send_post_with_file(self, url, data, file):
        response = requests.post(url=url, files=file, data=data)
        return self.handle_result(response)
