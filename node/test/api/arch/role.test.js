/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { RoleApiClient } from '../../../src/api/arch/role';
import { ApiKey, Host } from '../../../src/base/api_client';

export const roleTest = 'roleTest';

describe('role api test', () => {
    const api = new RoleApiClient(ApiKey, Host);

    test('roleList', async () => {
        const roleList = await api.roleList({});
        expect(roleList.roles).toBeTruthy();
        console.log(roleList);
    });
});