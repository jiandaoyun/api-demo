/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { ApiClient } from '../../base/api_client';

export class CorpCoopApiClient extends ApiClient {
    validVersions = ['v4'];
    defaultVersion = 'v4';

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
            path: `/corp_coop/guest/department_list`,
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
            path: `/corp_coop/guest/member_list`,
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
            path: `/corp_coop/guest/user_retrieve`,
            payload: {
                username
            }
        });
    }
}