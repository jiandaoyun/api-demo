/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';

export class FormDataApiClient extends ApiClient {
    validVersions = ['v4', 'v3', 'v2', 'v1'];
    defaultVersion = 'v4';

    /**
     * check version
     */
    async doRequest(options) {
        if (!this.validVersions.includes(this.version)) {
            this.version = this.defaultVersion;
        }
        return super.doRequest(options);
    }

    /**
     * 新建单条数据接口
     */
    async singleDataCreate(appId, entryId, data, options) {
        return await this.doRequest({
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_create`,
            payload: {
                data,
                is_start_workflow: options.isStartWorkflow,
                is_start_trigger: options.isStartTrigger,
                transaction_id: options.transactionId
            }
        });
    }

    /**
     * 查询单条数据接口
     */
    async singleDataQuery(appId, entryId, dataId) {
        return await this.doRequest({
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_retrieve`,
            payload: {
                data_id: dataId
            }
        });
    }

    /**
     * 修改单条数据接口
     */
    async singleDataUpdate(appId, entryId, data_id, data, options) {
        return await this.doRequest({
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_update`,
            payload: {
                data_id,
                data,
                is_start_trigger: options.isStartTrigger,
                transaction_id: options.transactionId
            }
        });
    }

    /**
    * 删除单条数据接口
    */
    async singleDataRemove(appId, entryId, dataId, options) {
        return await this.doRequest({
            version: 'v1',
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_delete`,
            payload: {
                data_id: dataId,
                is_start_trigger: options.isStartTrigger,
            }
        });
    }

    /**
    * 新建多条数据接口
    */
    async batchDataCreate(appId, entryId, dataList, options) {
        return await this.doRequest({
            version: 'v1',
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_batch_create`,
            payload: {
                data_list: dataList,
                is_start_workflow: options.isStartWorkflow,
                transaction_id: options.transactionId
            }
        });
    }

    /**
     * 查询多条数据接口
     */
    async batchDataQuery(appId, entryId, options) {
        return await this.doRequest({
            version: 'v1',
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data`,
            payload: {
                data_id: options.nextId,
                fields: options.fields,
                filter: options.filter,
                limit: options.limit
            }
        });
    }

    /**
     * 修改多条数据接口
     */
    async batchDataUpdate(appId, entryId, dataIds, data, options) {
        return await this.doRequest({
            version: 'v1',
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_batch_update`,
            payload: {
                data_ids: dataIds,
                data,
                transaction_id: options.transactionId
            }
        });
    }

    /**
    * 删除多条数据接口
    */
    async batchDataRemove(appId, entryId, dataIds) {
        return await this.doRequest({
            version: 'v1',
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data_batch_delete`,
            payload: {
                data_ids: dataIds
            }
        });
    }
}
