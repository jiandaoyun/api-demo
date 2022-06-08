/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */

import _ from 'lodash';
import axios from 'axios';
import qs from 'querystring';
import { defaultLimiter } from './limiter';

export const ApiKey = 'TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp';
export const Host = 'https://api.jiandaoyun.com/api';

export class ApiClient {
    /**
     * 构造方法
     * @param { String } apiKey - apiKey
     * @param { String } host - host
     * @param { String } version - version
     */
    constructor(apiKey, host, version) {
        this.host = host;
        this.apiKey = apiKey;
        this.version = version;
    }

    /**
     * 发送http请求
     * @param { Object } options - 请求参数
     * @param { String } options.version - 版本
     * @param { String } options.method - HTTP动词 (GET|POST)
     * @param { String } options.path - 请求path
     * @param { Object } options.query - url参数,可选
     * @param { Object } options.payload - 请求参数,可选
     */
    async doRequest(options) {
        const httpMethod = _.toUpper(options.method);
        const query = options.query ? `?${qs.stringify(options.query)}` : '';
        const axiosRequestConfig = {
            method: httpMethod,
            headers: {
                'Authorization': `Bearer ${this.apiKey}`,
                'Content-type': 'application/json;charset=utf-8'
            },
            url: `${this.host}/${options.version ?? this.version}/${options.path}${query}`,
            data: options.payload,
            timeout: 5000
        };
        let response;
        try {
            await defaultLimiter.tryBeforeRun();
            response = await axios(axiosRequestConfig);
            return response.data;
        } catch (e) {
            response = e.response;
            if (response) {
                const { status, data } = response;
                if (status && status > 200 && data.code && data.msg) {
                    throw new Error(`请求错误！Error Code: ${data.code}, Error Msg: ${data.msg}`);
                }
            }
            throw e;
        }
    }
}
