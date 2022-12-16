/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { AppApiClient } from '../../../src/api/jdy/app';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const appTest = 'appTest';

let appId;
describe('app api test', () => {
    const api = new AppApiClient(API_KEY, HOST, 'v5');

    test('appList', async () => {
        const appList = await api.appList({});
        console.log('appList result:' + JSON.stringify(appList));
        expect(appList['apps']).toBeTruthy();
        appId = appList['apps'][0].app_id;
    });

    test('entryList', async () => {
        const entryList = await api.entryList(appId, {});
        console.log('entryList result:' + JSON.stringify(entryList));
        expect(entryList.forms).toBeTruthy();
    });
});
