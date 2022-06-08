/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { CorpCoopApiClient } from '../../../src/api/arch/corp_coop';
import { ApiKey, Host } from '../../../src/base/api_client';

export const corpCoopTest = 'corpCoopTest';

describe('corp coop api test', () => {
    const api = new CorpCoopApiClient(ApiKey, Host);

    test('corpCoopDepartList', async () => {
        const corpCoopDepartList = await api.corpCoopDepartList({});
        expect(corpCoopDepartList.dept_list).toBeTruthy();
        console.log(corpCoopDepartList);
    });
});