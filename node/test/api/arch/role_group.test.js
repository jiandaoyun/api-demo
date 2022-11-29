/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/08
 */

import { RoleGroupApiClient } from '../../../src/api/arch/role_group';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const roleGroupTest = 'roleGroupTest';

const group_name = 'group_name';

let group_no;

describe('role group api test', () => {
    const api = new RoleGroupApiClient(API_KEY, HOST, 'v5');

    test('roleGroupCreate', async () => {
        const roleGroupCreate = await api.roleGroupCreate(group_name);
        console.log('roleGroupCreate result:' + JSON.stringify(roleGroupCreate));
        expect(roleGroupCreate['role_group']).toBeTruthy();
        expect(roleGroupCreate['role_group'].name).toEqual(group_name);
        group_no = roleGroupCreate['role_group'].group_no;
    });

    test('roleGroupList', async () => {
        const roleGroupList = await api.roleGroupList({});
        console.log('roleGroupList result=' + JSON.stringify(roleGroupList));
        expect(roleGroupList['role_groups']).toBeTruthy();
    });

    test('roleGroupUpdate', async () => {
        const roleGroupUpdate = await api.roleGroupUpdate(group_no, group_name + '_update');
        console.log('roleGroupUpdate result:' + JSON.stringify(roleGroupUpdate));
        expect(roleGroupUpdate['role_group']).toBeTruthy();
        expect(roleGroupUpdate['role_group'].name).toEqual(group_name + '_update');
    });

    test('roleGroupDelete', async () => {
        const roleGroupDelete = await api.roleGroupDelete(group_no);
        console.log('roleGroupDelete result:' + JSON.stringify(roleGroupDelete));
        expect(roleGroupDelete.status).toEqual('success');
    });
});
