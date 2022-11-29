/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';
import { FORM_DATA_BASE_PATH } from '../../constants/http_constant';

export class FormDataApiClient extends ApiClient {
    validVersions = ['v5'];
    defaultVersion = 'v5';

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
    async singleDataCreate(app_id, entry_id, data, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'create',
            payload: {
                app_id,
                entry_id,
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
    async singleDataQuery(app_id, entry_id, data_id) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'get',
            payload: {
                app_id, entry_id, data_id
            }
        });
    }

    /**
     * 修改单条数据接口
     */
    async singleDataUpdate(app_id, entry_id, data_id, data, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'update',
            payload: {
                app_id,
                entry_id,
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
    async singleDataRemove(app_id, entry_id, data_id, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'delete',
            payload: {
                app_id,
                entry_id,
                data_id,
                is_start_trigger: options.isStartTrigger,
            }
        });
    }

    /**
     * 新建多条数据接口
     */
    async batchDataCreate(app_id, entry_id, data_list, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'batch_create',
            payload: {
                app_id,
                entry_id,
                data_list,
                is_start_workflow: options.isStartWorkflow,
                transaction_id: options.transactionId
            }
        });
    }

    /**
     * 查询多条数据接口
     */
    async batchDataQuery(app_id, entry_id, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'list',
            payload: {
                app_id,
                entry_id,
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
    async batchDataUpdate(app_id, entry_id, data_ids, data, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'batch_update',
            payload: {
                app_id,
                entry_id,
                data_ids,
                data,
                transaction_id: options.transactionId
            }
        });
    }

    /**
     * 删除多条数据接口
     */
    async batchDataRemove(app_id, entry_id, data_ids) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_DATA_BASE_PATH + 'batch_delete',
            payload: {
                app_id, entry_id, data_ids
            }
        });
    }
}
