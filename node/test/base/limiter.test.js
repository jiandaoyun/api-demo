/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { defaultLimiter, sleep } from '../../src/base/limiter';

export const limiterTest = 'limiterTest';

describe('limiter test', () => {
    test('max speed', async () => {
        let count = 0;
        for (let i = 0; i < 15; i++) {
            defaultLimiter.tryBeforeRun().then(() => {
                console.log(new Date());
                count++;
            });
        }
        await sleep(2100);// 15个满速情况需要2s即可(0,1,2s)
        console.log('total run:', count);
    });

    test('slow speed', async () => {
        for (let i = 0; i < 3; i++) {
            await sleep(1000);
            defaultLimiter.tryBeforeRun().then(() => {
                console.log(new Date());
            });
        }
    });
});
