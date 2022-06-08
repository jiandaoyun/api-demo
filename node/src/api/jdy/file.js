/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';
import FormData from 'form-data';
import axios from 'axios';

export const transactionId = '87cd7d71-c6df-4281-9927-469094395677';

export class FileApiClient extends ApiClient {
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
      * 获取文件上传凭证和上传地址接口
      */
    async uploadToken(appId, entryId, transactionId) {
        return await this.doRequest({
            method: 'POST',
            path: `/app/${appId}/entry/${entryId}/file/get_upload_token`,
            payload: {
                transaction_id: transactionId
            }
        });
    }

    /**
      * 文件上传接口
      */
    async uploadFile(url, token, file) {
        let formData = new FormData();
        formData.append('token', token);
        formData.append('file', file);
        const axiosRequestConfig = {
            method: 'POST',
            url,
            data: formData
        };
        const response = await axios(axiosRequestConfig);
        return response.data;
    }
}
