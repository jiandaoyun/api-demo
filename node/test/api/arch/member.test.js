/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { MemberApiClient } from '../../../src/api/arch/member';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const memberTest = 'memberTest';

const RootDeptNo = 1;

const username = 'jianDaoYun';
const name = '小云';

describe('member api test', () => {
    const api = new MemberApiClient(API_KEY, HOST, 'v5');

    test('deptMemberList', async () => {
        const deptMemberList = await api.deptMemberList(RootDeptNo, {
            hasChild: true
        });
        console.log('deptMemberList result:' + JSON.stringify(deptMemberList));
        expect(deptMemberList.users).toBeTruthy();
    });

    test('userCreate', async () => {
        const user = await api.userCreate(name, {
            username,
            departments: [RootDeptNo]
        });
        console.log('userCreate result:' + JSON.stringify(user));
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual(name);
        expect(user.user.username).toEqual(username);

    });

    test('userInfo', async () => {
        const user = await api.userInfo(username);
        console.log('userInfo result:' + JSON.stringify(user));
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual(name);
        expect(user.user.username).toEqual(username);
    });

    test('userUpdate', async () => {
        const user = await api.userUpdate(username, {
            name: name + '_update'
        });
        console.log('userUpdate result:' + JSON.stringify(user));
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual(name + '_update');
    });

    test('userDelete', async () => {
        const response = await api.userDelete(username);
        console.log('userDelete result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
    });

    test('userImport', async () => {
        const response = await api.userImport([{
            name: name + '_import',
            username: username + '_import',
            departments: [RootDeptNo]
        }]);
        console.log('userImport result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
    });

    test('userBatchDelete', async () => {
        const response = await api.userBatchDelete([username + '_import']);
        console.log('userBatchDelete result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
    });
});
