/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { defaultLimiter, sleep } from '../../src/base/limiter';

describe('limiter test', () => {
    test('slow speed', async () => {
        for (let i = 0; i < 3; i++) {
            await sleep(1000);
            defaultLimiter.tryBeforeRun().then(() => {
                console.log(new Date());
            });
        }
    });

    test('max speed', async () => {
        let count = 0;
        for (let i = 0; i < 50; i++) {
            defaultLimiter.tryBeforeRun().then(() => {
                console.log(new Date());
                count++;
            });
        }
        await sleep(4900);
        console.log('total run:', count);
    });
});
