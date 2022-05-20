/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

export class Limiter {
    constructor(duration, limit) {
        this.seq = 0;
        this.bucket = duration;
        this.t = new Array(limit).fill(0);
    }

    /**
     * 限流阻塞
     */
    async tryBeforeRun() {
        const now = new Date().getTime();
        const interval = now - this.t[this.seq];
        if (interval < 0) {
            // 执行时间: t[seq]+bucket=now-interval+bucket
            // 等待时间: bucket-interval
            await sleep(this.bucket - interval);
            return await this.tryBeforeRun();
        }

        if (interval < this.bucket) {
            this.t[this.seq] += this.bucket;
            this.seq = (this.seq + 1) % this.t.length;
            await sleep(this.bucket - interval);
        } else {
            this.t[this.seq] = now;
            this.seq = (this.seq + 1) % this.t.length;
        }
    }
}

export async function sleep(time) {
    return new Promise((resolve) => {
        setTimeout(resolve, time);
    });
}

/**
 * 以1s限制5次为例, 创建长度为5的数组
 * 请求之间, 1和5,2和6,3和7,4和8, 5和9的差距 > 1s
 * 任意1s内都不可能出现6个请求.
 */
export let defaultLimiter = new Limiter(1000, 5);
