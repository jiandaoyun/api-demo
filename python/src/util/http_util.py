import requests
import json
from .limit_util import Limiter
import threading
from .encoder_util import MyEncoder


limiter = Limiter(1000, 5)

lock = threading.Lock()


# 带有认证信息的请求头
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


def send_post(request_param):
    headers = get_req_header(request_param.apiKey)
    data = None
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
        res = requests.post(url=request_param.url, data=data, headers=headers)
        return handle_result(res)
    finally:
        lock.release()


# 处理请求返回的结果
def handle_result(res):
    if res.status_code >= 400:
        raise Exception('Opps，Something Wrong: ', res.text)
    else:
        return res.json()
