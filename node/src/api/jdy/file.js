/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import { ApiClient } from '../../base/api_client';
import FormData from 'form-data';
import axios from 'axios';
import { FORM_BASE_PATH } from '../../constants/http_constant';

export class FileApiClient extends ApiClient {
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
     * 获取文件上传凭证和上传地址接口
     */
    async uploadToken(app_id, entry_id, transaction_id) {
        return await this.doRequest({
            method: 'POST',
            path: FORM_BASE_PATH + 'file/get_upload_token',
            payload: {
                transaction_id,
                app_id,
                entry_id
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
