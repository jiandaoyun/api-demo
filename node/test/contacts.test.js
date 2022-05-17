/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiKey } from './application.test';
import { ContactsApi } from '../src/contacts';

describe('contacts test', () => {
    const api = new ContactsApi(ApiKey);
    let deptNo;
    let rootDeptNo;

    test('deptCreate', async () => {
        const dept = await api.deptCreate();
        expect(dept.department).toBeTruthy();
        deptNo = dept.department.dept_no;
        rootDeptNo = dept.department.parent_no;
        console.log(dept);
    });

    test('deptUpdate', async () => {
        const dept = await api.deptUpdate(deptNo);
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

    test('deptMemberList', async () => {
        const deptMemberList = await api.deptMemberList(rootDeptNo);
        expect(deptMemberList.users).toBeTruthy();
        console.log(deptMemberList);
    });

    let username;

    test('userCreate', async () => {
        const user = await api.userCreate();
        expect(user.user).toBeTruthy();
        console.log(user);
        username = user.user.username;
    });

    test('userInfo', async () => {
        const user = await api.userInfo(username);
        expect(user.user).toBeTruthy();
        console.log(user);
    });

    test('userUpdate', async () => {
        const user = await api.userUpdate(username);
        expect(user.user).toBeTruthy();
        console.log(user);
    });

    test('userDelete', async () => {
        const response = await api.userDelete(username);
        expect(response.status).toEqual('success');
    });

    test('userBatchDelete', async () => {
        const response = await api.userBatchDelete([username]);
        expect(response.status).toEqual('success');
    });
});
