/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { Api } from '../../base/api';

export class AppApi extends Api {
    /**
     * 用户应用查询接口
     */
    async appList(skip, limit) {
        return await this.doRequest({
            method: 'POST',
            path: '/v1/app/retrieve_all',
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
            path: `/v1/app/${appId}/entry_retrieve`,
            payload: {
                skip,
                limit
            }
        });
    }
}
