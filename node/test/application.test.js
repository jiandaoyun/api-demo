/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApplicationApi } from '../src/application';

describe('application test', () => {
    const api = new ApplicationApi('TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp');
    let appId = '';

    test('userAppList', async () => {
        const appList = await api.userAppList();
        expect(appList.apps).toBeTruthy();
        console.log(appList);
        appId = appList.apps[0].app_id;
    });

    test('userEntryList', async () => {
        const entryList = await api.userEntryList(appId);
        expect(entryList.forms).toBeTruthy();
        console.log(entryList);
    });
});
