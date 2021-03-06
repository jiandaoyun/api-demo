/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { AppApiClient } from '../../../src/api/jdy/app';
import { ApiKey, Host } from '../../../src/base/api_client';

export const appTest = 'appTest';

export let appId = '';
export let entryId = '';

describe('app api test', () => {
    const api = new AppApiClient(ApiKey, Host);

    test('appList', async () => {
        const appList = await api.appList({});
        expect(appList.apps).toBeTruthy();
        console.log(appList);
        appId = appList.apps[0].app_id;
    });

    test('entryList', async () => {
        const entryList = await api.entryList(appId, {});
        expect(entryList.forms).toBeTruthy();
        console.log(entryList);
        entryId = entryList.forms[0].entry_id;
    });
});
