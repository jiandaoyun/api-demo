/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */
import _ from 'lodash';
import axios from 'axios';
import qs from 'querystring';

export class Api {
    /**
     * 构造方法
     * @param { String } apiKey - apiKey
     * @param { String } host - host
     */
    constructor(apiKey, host) {
        this.host = apiKey;
        this.apiKey = apiKey;
    }

    /**
     * 发送http请求
     * @param { Object } options - 请求参数
     * @param { String } options.method - HTTP动词 (GET|POST)
     * @param { String } options.path - 请求path
     * @param { Object } options.query - url参数,可选
     * @param { Object } options.payload - 请求参数,可选
     */
    async doRequest(options) {
        const httpMethod = _.toUpper(options.method);
        const axiosRequestConfig = {
            method: httpMethod,
            headers: {
                'Authorization': `Bearer ${this.apiKey}`, 'Content-type': 'application/json;charset=utf-8'
            },
            url: options.query ? `${this.host}${options.path}?${qs.stringify(options.query)}` : `${this.host}${options.path}`,
            data: options.payload,
            timeout: 5000
        };
        let response;
        try {
            response = await axios(axiosRequestConfig);
            return response.data;
        } catch (e) {
            response = e.response;
            const { status, data } = response;
            if (status && status > 200) {
                throw new Error(`请求错误！Error Code: ${data.code}, Error Msg: ${data.msg}`);
            } else {
                throw e;
            }
        }
    }
}
