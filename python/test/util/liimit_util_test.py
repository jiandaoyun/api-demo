from src.api.arch.dept import DeptApiClient
from src.constants.http_constant import HttpConstant
import threading

lock = threading.Lock()

deptApiClient = DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST)


class MyThread(threading.Thread):
    def __init__(self, thread_id, name):
        threading.Thread.__init__(self)
        self.thread_id = thread_id
        self.name = name

    def run(self):
        for x in range(0, 20):
            result = deptApiClient.deptList(1, True)
            print(self.name + ' result:', result)


if __name__ == '__main__':
    thread1 = MyThread(1, 'thread-1')
    thread2 = MyThread(2, 'thread-2')
    thread3 = MyThread(3, 'thread-3')
    thread1.start()
    thread2.start()
    thread3.start()
