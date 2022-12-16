/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { DeptApiClient } from '../../../src/api/arch/dept';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const deptTest = 'deptTest';

let deptNo;

describe('dept api test', () => {
    const api = new DeptApiClient(API_KEY, HOST, 'v5');

    test('deptCreate', async () => {
        const dept = await api.deptCreate('Demo研发部门', {});
        console.log('deptCreate result:' + JSON.stringify(dept));
        expect(dept['department']).toBeTruthy();
        deptNo = dept['department']['dept_no'];
    });


    test('deptList', async () => {
        const deptList = await api.deptList(deptNo, {
            hasChild: true
        });
        console.log('deptList result:' + JSON.stringify(deptList));
        expect(deptList.departments).toBeTruthy();
    });


    test('deptUpdate', async () => {
        const name = 'Demo测试部门';
        const dept = await api.deptUpdate(deptNo, name);
        console.log('deptUpdate result:' + JSON.stringify(dept));
        expect(dept['department']['dept_no']).toEqual(deptNo);
        expect(dept['department']['name']).toEqual(name);
    });

    test('deptDelete', async () => {
        const response = await api.deptDelete(deptNo);
        console.log('deptCreate result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
    });

    test('deptByIntegrateId', async () => {
        try {
            // 集成模式才可以调用
            const integrateId = 58335612;
            const response = await api.deptByIntegrateId('58335612');
            console.log('deptByIntegrateId result:' + JSON.stringify(response));
            expect(response['department']['dept_no']).toEqual(integrateId);
        } catch (e) {
            console.log(e);
        }
    });

    test('departmentImport', async () => {
        try {
            const response = await api.departmentImport([{
                parent_no: 1,
                dept_no: 10018,
                name: 'node dept import'
            }]);
            console.log('departmentImport result:' + JSON.stringify(response));
            expect(response.status).toEqual('success');
        } catch (e) {
            console.log(e);
        }
    });
});
