/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiKey, Host } from '../../../src/base/api_client';
import { DeptApiClient } from '../../../src/api/arch/dept';

export const deptTest = 'deptTest';

let deptNo;

describe('dept api test', () => {
    const api = new DeptApiClient(ApiKey, Host);

    test('deptCreate', async () => {
        const dept = await api.deptCreate('Demo研发部门', {});
        expect(dept.department).toBeTruthy();
        deptNo = dept.department.dept_no;
        console.log(dept);
    });

    test('deptUpdate', async () => {
        const dept = await api.deptUpdate(deptNo, 'Demo测试部门');
        expect(dept.department).toBeTruthy();
        console.log(dept);
    });

    test('deptList', async () => {
        const deptList = await api.deptList(deptNo, {
            hasChild: true
        });
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

    test('departmentImport', async () => {
        try {
            const response = await api.departmentImport([]);
            expect(response.status).toEqual('success');
        } catch (e) {
            console.log(e);
        }
    });
});
