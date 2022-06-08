/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiKey, Host } from '../../../src/base/api_client';
import { MemberApiClient } from '../../../src/api/arch/member';

export const memberTest = 'memberTest';

const RootDeptNo = 1;

let username;

describe('member api test', () => {
    const api = new MemberApiClient(ApiKey, Host);

    test('deptMemberList', async () => {
        const deptMemberList = await api.deptMemberList(RootDeptNo, {
            hasChild: true
        });
        expect(deptMemberList.users).toBeTruthy();
        console.log(deptMemberList);
    });

    test('userCreate', async () => {
        const user = await api.userCreate('小云', {
            username: 'jiandaoyun'
        });
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual('小云');
        expect(user.user.username).toEqual('jiandaoyun');
        console.log(user);
        username = user.user.username;
    });

    test('userInfo', async () => {
        const user = await api.userInfo(username);
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual('小云');
        expect(user.user.username).toEqual('jiandaoyun');
        console.log(user);
    });

    test('userUpdate', async () => {
        const user = await api.userUpdate(username, {
            name: '小简'
        });
        expect(user.user).toBeTruthy();
        expect(user.user.name).toEqual('小简');
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

    test('userImport', async () => {
        const response = await api.userImport([]);
        expect(response.status).toEqual('success');
    });
});
