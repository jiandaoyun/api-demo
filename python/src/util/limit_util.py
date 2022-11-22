import time


# 限流器
class Limiter:
    def __init__(self, duration, limit):
        self.seq = 0
        self.bucket = duration
        self.request_time_list = [0 for x in range(0, limit)]

    def tryBeforeRun(self):
        now_mill_time = int(round(time.time() * 1000))
        interval = now_mill_time - self.request_time_list[self.seq]
        if interval < 0:
            #  这边是毫秒数 需要修改成秒
            time.sleep((self.bucket - interval) / 1000)
            self.tryBeforeRun()
        if interval < self.bucket:
            self.request_time_list[self.seq] = self.request_time_list[self.seq] + self.bucket
            #  这边是毫秒数 需要修改
            time.sleep((self.bucket - interval) / 1000)
        else:
            self.request_time_list[self.seq] = now_mill_time
        self.seq = (self.seq + 1) % len(self.request_time_list)
