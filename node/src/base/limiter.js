/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

/**
 * 1和5,2和6,3和7,4和8, 5和9的差距 > 1s
 * 任意1s内都不可能出现6个请求.
 */
let seq = 0;
let t = [0, 0, 0, 0, 0];
const bucket = 1200;// 设置1000的话, 1.网络延迟, 2.定时触发延迟等都会导致一定的限流出错

/**
 * 限流阻塞
 */
export async function tryBeforeRun() {
    const now = new Date().getTime();
    const interval = now - t[seq];
    if (interval < 0) {
        return await tryAgainAfter(-interval);
    }

    if (interval < bucket) {
        t[seq] += bucket;
        await sleep(bucket - interval);
    } else {
        t[seq] = now;
    }
    seq = (seq + 1) % t.length;
}

const tryAgainAfter = async (interval) => {
    await sleep(interval);
    return await tryBeforeRun();
};

export async function sleep(time) {
    return new Promise((resolve) => {
        setTimeout(resolve, time);
    });
}

