/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/08
 */

import { RoleApiClient } from '../../../src/api/arch/role';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const roleTest = 'roleTest';

const role_name = 'role_name';
const group_no = 120;
const userNameList = ['R-gDIIDws8'];
let roleNo;

describe('role api test', () => {
    const api = new RoleApiClient(API_KEY, HOST, 'v5');

    test('roleCreate', async () => {
        const roleCreate = await api.roleCreate(role_name, group_no);
        console.log('roleCreate result:' + JSON.stringify(roleCreate));
        expect(roleCreate['role']).toBeTruthy();
        expect(roleCreate['role'].name).toEqual(role_name);
        roleNo = roleCreate['role'].role_no;
    });

    test('roleList', async () => {
        const roleList = await api.roleList({});
        console.log('roleList result:' + JSON.stringify(roleList));
        expect(roleList['roles']).toBeTruthy();
    });

    test('roleUpdate', async () => {
        const roleUpdate = await api.roleUpdate(roleNo, group_no, {
            name: role_name + '_update'
        });
        console.log('roleUpdate result:' + JSON.stringify(roleUpdate));
        expect(roleUpdate['role']).toBeTruthy();
        expect(roleUpdate['role'].name).toEqual(role_name + '_update');
    });

    test('roleAddMembers', async () => {
        const roleAddMembers = await api.roleAddMembers(roleNo, {
            usernames: userNameList
        });
        console.log('roleAddMembers result:' + JSON.stringify(roleAddMembers));
        expect(roleAddMembers.status).toEqual('success');
    });

    test('roleMemberList', async () => {
        const roleMemberList = await api.roleMemberList(roleNo, {});
        console.log('roleMemberList result:' + JSON.stringify(roleMemberList));
        expect(roleMemberList.users).toBeTruthy();
        expect(roleMemberList.users[0].username).toEqual(userNameList[0]);
    });

    test('roleRemoveMembers', async () => {
        const roleRemoveMembers = await api.roleRemoveMembers(roleNo, userNameList);
        console.log('roleRemoveMembers result:' + JSON.stringify(roleRemoveMembers));
        expect(roleRemoveMembers.status).toEqual('success');
    });

    test('roleDelete', async () => {
        const roleDelete = await api.roleDelete(roleNo);
        console.log('roleDelete result:' + JSON.stringify(roleDelete));
        expect(roleDelete.status).toEqual('success');
    });
});
