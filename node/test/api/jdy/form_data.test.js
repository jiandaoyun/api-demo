/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/07
 */

import { FormDataApiClient } from '../../../src/api/jdy/form_data';
import { API_KEY, HOST, APP_ID, ENTRY_ID } from '../../../src/constants/http_constant';

export const formDataTest = 'formDataTest';

const NUM_WIDGET = '_widget_1669106585318';
const TEXT_WIDGET = '_widget_1669106585317';
const ADDRESS_WIDGET = '_widget_1669106585320';
const DATA_WIDGET = '_widget_1669106585319';

const data_for_create = {}
data_for_create[NUM_WIDGET] = { value: 1 };
data_for_create[TEXT_WIDGET] = { value: '单行文本1' };
data_for_create[ADDRESS_WIDGET] = {
    value: {
        province: '北京市',
        city: '北京市',
        district: '东城区',
        detail: '详细地址1'
    }
};
data_for_create[DATA_WIDGET] = {
    value: 1654176800000
};

const data_for_update = {}
data_for_update[NUM_WIDGET] = { value: 2 };
data_for_update[TEXT_WIDGET] = { value: '单行文本2' };
data_for_update[ADDRESS_WIDGET] = {
    value: {
        province: '北京市',
        city: '北京市',
        district: '东城区',
        detail: '详细地址2'
    }
};
data_for_update[DATA_WIDGET] = {
    value: 1654276800000
};


let dataId;
let dataIds;

describe('form data api test', () => {
    const api = new FormDataApiClient(API_KEY, HOST, 'v5');

    test('singleDataCreate', async () => {
        const formData = await api.singleDataCreate(APP_ID, ENTRY_ID, data_for_create, {});
        console.log('singleDataCreate result:' + JSON.stringify(formData));
        expect(formData.data).toBeTruthy();
        expect(formData.data[NUM_WIDGET]).toEqual(data_for_create[NUM_WIDGET].value);
        dataId = formData.data._id;
    });

    test('singleDataQuery', async () => {
        const formData = await api.singleDataQuery(APP_ID, ENTRY_ID, dataId);
        console.log('singleDataQuery result:' + JSON.stringify(formData));
        expect(formData.data).toBeTruthy();
        expect(formData.data._id).toEqual(dataId);
        expect(formData.data[NUM_WIDGET]).toEqual(data_for_create[NUM_WIDGET].value);
    });

    test('singleDataUpdate', async () => {
        const formData = await api.singleDataUpdate(APP_ID, ENTRY_ID, dataId, data_for_update, {});
        console.log('singleDataUpdate result:' + JSON.stringify(formData));
        expect(formData.data).toBeTruthy();
        expect(formData.data._id).toEqual(dataId);
        expect(formData.data[NUM_WIDGET]).toEqual(data_for_update[NUM_WIDGET].value);
    });

    test('singleDataRemove', async () => {
        const response = await api.singleDataRemove(APP_ID, ENTRY_ID, dataId, {});
        console.log('singleDataRemove result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
    });


    test('batchDataCreate', async () => {
        const response = await api.batchDataCreate(APP_ID, ENTRY_ID, [data_for_create, data_for_create], {});
        console.log('batchDataCreate result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
        expect(response['success_count']).toEqual(2);
        expect(response['success_ids']).toBeTruthy();
        dataIds = response['success_ids'];
    });

    test('batchDataQuery', async () => {
        const limit = 2;
        const response = await api.batchDataQuery(APP_ID, ENTRY_ID, {
            limit
        });
        console.log('batchDataQuery result:' + JSON.stringify(response));
        expect(response.data).toBeTruthy();
        expect(response.data.length).toEqual(limit);
    });

    test('batchDataUpdate', async () => {
        const response = await api.batchDataUpdate(APP_ID, ENTRY_ID, dataIds, data_for_update, {});
        console.log('batchDataUpdate result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
        expect(response['success_count']).toEqual(2);
    });

    test('batchDataRemove', async () => {
        const response = await api.batchDataRemove(APP_ID, ENTRY_ID, dataIds);
        console.log('batchDataRemove result:' + JSON.stringify(response));
        expect(response.status).toEqual('success');
        expect(response['success_count']).toEqual(2);
    });
});
