/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { AppApi } from '../../../src/api/jdy/app';
import { ApiKey, Host } from '../../../src/base/api';

export const appTest = 'appTest';

describe('app api test', () => {
    const api = new AppApi(ApiKey, Host);
    let appId = '';

    test('appList', async () => {
        const appList = await api.appList(0, 10);
        expect(appList.apps).toBeTruthy();
        console.log(appList);
        appId = appList.apps[0].app_id;
    });

    test('entryList', async () => {
        const entryList = await api.entryList(appId, 0, 10);
        expect(entryList.forms).toBeTruthy();
        console.log(entryList);
    });
});
