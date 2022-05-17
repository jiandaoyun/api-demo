/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApplicationApi } from '../src/application';

export const ApiKey = 'TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp';

describe('application test', () => {
    const api = new ApplicationApi(ApiKey);
    let appId = '';

    test('appList', async () => {
        const appList = await api.appList();
        expect(appList.apps).toBeTruthy();
        console.log(appList);
        appId = appList.apps[0].app_id;
    });

    test('entryList', async () => {
        const entryList = await api.entryList(appId);
        expect(entryList.forms).toBeTruthy();
        console.log(entryList);
    });
});
