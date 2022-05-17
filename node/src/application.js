/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */
import { Api } from './api';

export class ApplicationApi extends Api {
    /**
     * 用户应用查询接口
     */
    async userAppList() {
        return await this.doRequest({
            method: 'POST',
            path: '/api/v1/app/retrieve_all',
            payload: {
                skip: 0,
                limit: 10
            }
        });
    }

    /**
     * 用户表单查询接口
     */
    async userEntryList(appId) {
        return await this.doRequest({
            method: 'POST',
            path: `/api/v1/app/${appId}/entry_retrieve`,
            payload: {
                skip: 0,
                limit: 10
            }
        });
    }
}
