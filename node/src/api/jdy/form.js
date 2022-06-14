/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/02
*/


import { ApiClient } from '../../base/api_client';

export class FormApiClient extends ApiClient {
    validVersions = ['v2', 'v1'];
    defaultVersion = 'v2';

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
     * 表单字段查询接口
     */
    async formWidgets(appId, entryId) {
        return await this.doRequest({
            method: 'POST',
            path: `app/${appId}/entry/${entryId}/widgets`
        });
    }
}