/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { sleep, tryBeforeRun } from '../../src/base/limiter';

describe('limiter test', () => {
    test('slow speed', async () => {
        for (let i = 0; i < 3; i++) {
            await sleep(1000);
            await tryBeforeRun();
        }
    });

    test('max speed', async () => {
        let count = 0;
        for (let i = 0; i < 50; i++) {
            tryBeforeRun().then(() => {
                console.log(new Date());
                count++;
            });
        }
        await sleep(4900);
        console.log('total run:', count);
    });
});
