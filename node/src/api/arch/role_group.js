/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { ApiClient } from '../../base/api_client';

export class RoleGroupApiClient extends ApiClient {
    validVersions = ['v2'];
    defaultVersion = 'v2';

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
     * 列出角色组
     */
    async roleGroupList(options) {
        return await this.doRequest({
            method: 'POST',
            path: `role_group/list`,
            payload: {
                ...options
            }
        });
    }

    /**
     * 创建角色组
     */
    async roleGroupCreate(name) {
        return await this.doRequest({
            method: 'POST',
            path: `role_group/create`,
            payload: {
                name
            }
        });
    }

    /**
    * 更新角色组
    */
    async roleGroupUpdate(roleGroupNo, name) {
        return await this.doRequest({
            method: 'POST',
            path: `role_group/update`,
            payload: {
                role_group_no: roleGroupNo,
                name
            }
        });
    }

    /**
    * 删除角色组
    */
    async roleGroupDelete(roleGroupNo) {
        return await this.doRequest({
            method: 'POST',
            path: `role_group/delete`,
            payload: {
                role_group_no: roleGroupNo,
            }
        });
    }
}