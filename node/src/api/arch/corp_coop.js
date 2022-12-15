/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/08
 */

import { ApiClient } from '../../base/api_client';
import { CORP_COOP_BASE_PATH } from '../../constants/http_constant'

export class CorpCoopApiClient extends ApiClient {
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
     * 列出我连接的企业
     */
    async corpCoopDepartList(options) {
        return await this.doRequest({
            method: 'POST',
            path: CORP_COOP_BASE_PATH + 'department/list',
            payload: {
                dept_no: options.deptNo
            }
        });
    }

    /**
     * 列出我连接的企业对接人
     */
    async corpCoopMemberList(options) {
        return await this.doRequest({
            method: 'POST',
            path: CORP_COOP_BASE_PATH + 'user/list',
            payload: {
                dept_no: options.deptNo
            }
        });
    }

    /**
     * 列出我连接的企业对接人详细信息
     */
    async corpCoopUserInfo(username) {
        return await this.doRequest({
            method: 'POST',
            path: CORP_COOP_BASE_PATH + 'user/get',
            payload: {
                username
            }
        });
    }
}
