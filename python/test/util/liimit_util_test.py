import time

from src.test.api.arch.dept_demo_test import deptList
from src.util.http_util import limiter
import threading

lock = threading.Lock()


class MyThread(threading.Thread):
    def __init__(self, threadID, name):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name

    def run(self):
        for x in range(0, 20):
            deptList()


if __name__ == '__main__':
    thread1 = MyThread(1, 'thread-1')
    thread2 = MyThread(2, 'thread-2')
    thread3 = MyThread(3, 'thread-3')
    thread1.start()
    thread2.start()
    thread3.start()

