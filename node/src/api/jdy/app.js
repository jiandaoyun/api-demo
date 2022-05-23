/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';

export class AppApiClient extends ApiClient {
    /**
     * 用户应用查询接口
     */
    async appList(skip, limit) {
        return await this.doRequest({
            method: 'POST',
            path: 'app/retrieve_all',
            payload: {
                skip,
                limit
            }
        });
    }

    /**
     * 用户表单查询接口
     */
    async entryList(appId, skip, limit) {
        return await this.doRequest({
            method: 'POST',
            path: `app/${appId}/entry_retrieve`,
            payload: {
                skip,
                limit
            }
        });
    }
}
