/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/20
 */

import { deptTest } from './api/arch/dept.test';
import { memberTest } from './api/arch/member.test';
import { appTest } from './api/jdy/app.test';

describe('main test', () => {
    test('load', () => {
        console.log(deptTest);
        console.log(memberTest);
        console.log(appTest);
    });
});
