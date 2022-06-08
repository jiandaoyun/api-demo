/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/20
 */

import { limiterTest } from './base/limiter.test';
import { deptTest } from './api/arch/dept.test';
import { memberTest } from './api/arch/member.test';
import { roleTest } from './api/arch/role.test';
import { roleGroupTest } from './api/arch/role_group.test';
import { corpCoopTest } from './api/arch/corp_coop.test';
import { appTest } from './api/jdy/app.test';
import { formTest } from './api/jdy/form.test';
import { formDataTest } from './api/jdy/form_data.test';
import { fileTest } from './api/jdy/file.test';
import { workflowTest } from './api/jdy/workflow.test';

describe('main test', () => {
    test('load', () => {
        console.log(limiterTest);
        console.log(deptTest);
        console.log(memberTest);
        console.log(roleTest);
        console.log(roleGroupTest);
        console.log(corpCoopTest);
        console.log(appTest);
        console.log(formTest);
        console.log(formDataTest);
        console.log(fileTest);
        console.log(workflowTest);
    });
});
