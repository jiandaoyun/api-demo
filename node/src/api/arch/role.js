/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/08
 */

import { ApiClient } from '../../base/api_client';
import { ROLE_BASE_PATH } from '../../constants/http_constant';

export class RoleApiClient extends ApiClient {
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
     * 列出角色
     */
    async roleList(options) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'list',
            payload: {
                ...options
            }
        });
    }

    /**
     * 创建角色
     */
    async roleCreate(name, groupNo) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'create',
            payload: {
                name,
                group_no: groupNo
            }
        });
    }

    /**
     * 更新角色
     */
    async roleUpdate(roleNo, groupNo, options) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'update',
            payload: {
                role_no: roleNo,
                group_no: groupNo,
                name: options.name
            }
        });
    }

    /**
     * 删除角色
     */
    async roleDelete(roleNo) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'delete',
            payload: {
                role_no: roleNo
            }
        });
    }

    /**
     * 列出角色下所有成员
     */
    async roleMemberList(roleNo, options) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'user/list',
            payload: {
                role_no: roleNo,
                ...options
            }
        });
    }

    /**
     * 为自建角色批量添加成员
     */
    async roleAddMembers(roleNo, usernames) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'add_members',
            payload: {
                role_no: roleNo,
                usernames
            }
        });
    }

    /**
     * 为自建角色批量移除成员
     */
    async roleRemoveMembers(roleNo, usernames) {
        return await this.doRequest({
            method: 'POST',
            path: ROLE_BASE_PATH + 'remove_members',
            payload: {
                role_no: roleNo,
                usernames
            }
        });
    }
}
