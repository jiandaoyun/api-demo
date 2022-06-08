/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/07
*/

import { FormDataApiClient } from '../../../src/api/jdy/form_data';
import { ApiKey, Host } from '../../../src/base/api_client';
import { appId, entryId } from './app.test';

export const formDataTest = 'formDataTest';

const emptyData = {};

export let dataId;
let dataIds;

describe('form data api test', () => {
    const api = new FormDataApiClient(ApiKey, Host);

    test('singleDataCreate', async () => {
        const formData = await api.singleDataCreate(appId, entryId, emptyData, {});
        expect(formData.data).toBeTruthy();
        console.log(formData);
        dataId = formData.data._id;
    });

    test('singleDataQuery', async () => {
        const formData = await api.singleDataQuery(appId, entryId, dataId);
        expect(formData.data).toBeTruthy();
        expect(formData.data._id).toEqual(dataId);
        console.log(formData);
    });

    test('singleDataUpdate', async () => {
        const formData = await api.singleDataUpdate(appId, entryId, dataId, emptyData, {});
        expect(formData.data).toBeTruthy();
        expect(formData.data._id).toEqual(dataId);
        console.log(formData);
    });

    test('singleDataRemove', async () => {
        const response = await api.singleDataRemove(appId, entryId, dataId, {});
        expect(response.status).toEqual('success');
    });


    test('batchDataCreate', async () => {
        const response = await api.batchDataCreate(appId, entryId, [emptyData, emptyData], {});
        expect(response.status).toEqual('success');
        expect(response.success_count).toEqual(2);
        expect(response.success_ids).toBeTruthy();
        console.log(response);
        dataIds = response.success_ids;
    });

    test('batchDataQuery', async () => {
        const response = await api.batchDataQuery(appId, entryId, {
            limit: 2
        });
        expect(response.data).toBeTruthy();
        console.log(response);
    });

    test('batchDataUpdate', async () => {
        const response = await api.batchDataUpdate(appId, entryId, dataIds, emptyData, {});
        expect(response.status).toEqual('success');
        expect(response.success_count).toEqual(2);
        console.log(response);
    });

    test('batchDataRemove', async () => {
        const response = await api.batchDataRemove(appId, entryId, dataIds);
        expect(response.status).toEqual('success');
        expect(response.success_count).toEqual(2);
        console.log(response);
    });
});
