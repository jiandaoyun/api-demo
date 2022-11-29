/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/08
*/

import { ApiClient } from '../../base/api_client';
import { ROLE_GROUP_BASE_PATH } from '../../constants/http_constant';

export class RoleGroupApiClient extends ApiClient {
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
     * 列出角色组
     */
    async roleGroupList(options) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_GROUP_BASE_PATH + 'list',
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
            path: ROLE_GROUP_BASE_PATH + 'create',
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
            path: ROLE_GROUP_BASE_PATH + 'update',
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
            path: ROLE_GROUP_BASE_PATH + 'delete',
            payload: {
                role_group_no: roleGroupNo,
            }
        });
    }
}
