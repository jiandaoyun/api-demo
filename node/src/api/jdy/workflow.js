/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';

export class WorkflowApiClient extends ApiClient {
    validVersions = ['v1'];
    defaultVersion = 'v1';

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
      * 获取单条表单流程数据的审批意见
      */
    async approvalComments(appId, entryId, dataId, options) {
        return await this.doRequest({
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/data/${dataId}/approval_comments`,
            payload: {
                skip: options.skip ?? 0
            }
        });
    }
}
