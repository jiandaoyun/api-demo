/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/07
*/

import { FileApiClient, transactionId } from '../../../src/api/jdy/file';
import { ApiKey, Host } from '../../../src/base/api_client';
import { appId, entryId } from './app.test';
import fs from 'fs/promises';
import path from 'path';

export const fileTest = 'fileTest';

let token;
let url;

describe('file api test', () => {
    const api = new FileApiClient(ApiKey, Host);

    test('uploadToken', async () => {
        const response = await api.uploadToken(appId, entryId, transactionId);
        expect(response.token_and_url_list).toBeTruthy();
        expect(response.token_and_url_list.length).toEqual(100);
        token = response.token_and_url_list[0].token;
        url = response.token_and_url_list[0].url;
    });

    test('uploadFile', async () => {
        const file = await fs.readFile(path.join(__dirname, './file'));
        const response = await api.uploadFile(url, token, file);
        expect(response.key).toBeTruthy();
        console.log(response);
    });
});