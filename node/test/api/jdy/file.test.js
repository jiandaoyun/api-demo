/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/07
 */

import { FileApiClient } from '../../../src/api/jdy/file';
import { API_KEY, HOST, APP_ID, ENTRY_ID } from '../../../src/constants/http_constant';
import fs from 'fs/promises';
import path from 'path';

export const fileTest = 'fileTest';
const transactionId = '87cd7d71-c6df-4281-9927-469094395677';

let token;
let url;

describe('file api test', () => {
    const api = new FileApiClient(API_KEY, HOST, 'v5');

    test('uploadToken', async () => {
        const response = await api.uploadToken(APP_ID, ENTRY_ID, transactionId);
        console.log('uploadToken result:' + JSON.stringify(response));
        expect(response['token_and_url_list']).toBeTruthy();
        expect(response['token_and_url_list'].length).toEqual(100);
        token = response['token_and_url_list'][0].token;
        url = response['token_and_url_list'][0].url;
    });

    test('uploadFile', async () => {
        const file = await fs.readFile(path.join(__dirname, './file'));
        console.log('uploadFile result:' + JSON.stringify(file));
        const response = await api.uploadFile(url, token, file);
        expect(response.key).toBeTruthy();
    });
});
