/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/07
*/

import { FormApiClient } from '../../../src/api/jdy/form';
import { ApiKey, Host } from '../../../src/base/api_client';
import { appId, entryId } from './app.test';

export const formTest = 'formTest';

describe('form api test', () => {
    const api = new FormApiClient(ApiKey, Host);

    test('formWidgets', async () => {
        const formWidgets = await api.formWidgets(appId, entryId);
        expect(formWidgets.widgets).toBeTruthy();
        expect(formWidgets.sysWidgets).toBeTruthy();
        expect(formWidgets.dataModifyTime).toBeTruthy();
        console.log(formWidgets);
    });
});