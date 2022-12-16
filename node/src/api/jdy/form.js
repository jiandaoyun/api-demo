/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/02
 */


import { ApiClient } from '../../base/api_client';
import { FORM_BASE_PATH } from '../../constants/http_constant';

export class FormApiClient extends ApiClient {
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
     * 表单字段查询接口
     */
    async formWidgets(app_id, entry_id) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_BASE_PATH + 'widget/list',
            payload: {
                app_id,
                entry_id
            }
        });
    }
}
