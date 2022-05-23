/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiKey, Host } from '../../../src/base/api_client';
import { DeptApi } from '../../../src/api/arch/dept';

export const deptTest = 'deptTest';

describe('dept api test', () => {
    const api = new DeptApi(ApiKey, Host, 'v2');
    let deptNo;

    test('deptCreate', async () => {
        const dept = await api.deptCreate('研发部门');
        expect(dept.department).toBeTruthy();
        deptNo = dept.department.dept_no;
        console.log(dept);
    });

    test('deptUpdate', async () => {
        const dept = await api.deptUpdate(deptNo, '测试部门');
        expect(dept.department).toBeTruthy();
        console.log(dept);
    });

    test('deptList', async () => {
        const deptList = await api.deptList(deptNo);
        expect(deptList.departments).toBeTruthy();
        console.log(deptList);
    });

    test('deptDelete', async () => {
        const response = await api.deptDelete(deptNo);
        expect(response.status).toEqual('success');
    });

    test('deptByIntegrateId', async () => {
        try {
            await api.deptByIntegrateId('1005');
        } catch (e) {
            console.log(e);
        }
    });
});
