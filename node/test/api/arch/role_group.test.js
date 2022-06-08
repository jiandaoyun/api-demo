/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { RoleGroupApiClient } from '../../../src/api/arch/role_group';
import { ApiKey, Host } from '../../../src/base/api_client';

export const roleGroupTest = 'roleGroupTest';

describe('role group api test', () => {
    const api = new RoleGroupApiClient(ApiKey, Host);

    test('roleGroupList', async () => {
        const roleGroupList = await api.roleGroupList({});
        expect(roleGroupList.role_groups).toBeTruthy();
        console.log(roleGroupList);
    });
});