/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';
import { FORM_BASE_PATH, APP_BASE_PATH } from '../../constants/http_constant';

export class AppApiClient extends ApiClient {
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
     * 用户应用查询接口
     */
    async appList(options) {
        return await this.doRequest({
            method: 'POST',
            path: APP_BASE_PATH + 'list',
            payload: {
                ...options
            }
        });
    }

    /**
     * 用户表单查询接口
     */
    async entryList(app_id, options) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_BASE_PATH + 'list',
            payload: {
                app_id,
                ...options
            }
        });
    }
}
