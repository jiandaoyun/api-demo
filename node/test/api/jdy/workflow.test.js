/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { WorkflowApiClient } from '../../../src/api/jdy/workflow';
import { ApiKey, Host } from '../../../src/base/api_client';
import { appId, entryId } from './app.test';
import { dataId } from './form_data.test';

export const workflowTest = 'workflowTest';

describe('workflow api test', () => {
    const api = new WorkflowApiClient(ApiKey, Host);

    test('approvalComments', async () => {
        try {
            const response = await api.approvalComments(appId, entryId, dataId, {});
            expect(response.approveCommentList).toBeTruthy();
            console.log(response);
        } catch (err) {
            // 数据不存在
            console.log(err);
        }
    });
});