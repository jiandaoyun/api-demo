/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/07
 */

import { FormApiClient } from '../../../src/api/jdy/form';
import { API_KEY, HOST, APP_ID, ENTRY_ID } from '../../../src/constants/http_constant';

export const formTest = 'formTest';

describe('form api test', () => {
    const api = new FormApiClient(API_KEY, HOST, 'v5');

    test('formWidgets', async () => {
        const formWidgets = await api.formWidgets(APP_ID, ENTRY_ID);
        console.log('formWidgets result:' + JSON.stringify(formWidgets));
        expect(formWidgets['widgets']).toBeTruthy();
        expect(formWidgets['sysWidgets']).toBeTruthy();
        expect(formWidgets['dataModifyTime']).toBeTruthy();
    });
});
