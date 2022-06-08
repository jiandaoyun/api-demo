/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';

export class MemberApiClient extends ApiClient {
    validVersions = ['v2', 'v1'];
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
     * 获取部门成员（递归）
     */
    async deptMemberList(deptNo, options) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/member_list`,
            payload: {
                has_child: options.hasChild
            }
        });
    }

    /**
     * 获取成员
     */
    async userInfo(username) {
        return await this.doRequest({
            method: 'POST',
            path: `user/${username}/user_retrieve`
        });
    }

    /**
     * 创建成员
     */
    async userCreate(name, options) {
        return await this.doRequest({
            method: 'POST',
            path: `user/create`,
            payload: {
                name,
                ...options
            }
        });
    }

    /**
     * 更新成员
     */
    async userUpdate(username, options) {
        return await this.doRequest({
            method: 'POST',
            path: `user/${username}/update`,
            payload: {
                ...options
            }
        });
    }

    /**
     * 删除成员
     */
    async userDelete(username) {
        return await this.doRequest({
            method: 'POST',
            path: `user/${username}/delete`
        });
    }

    /**
     * 批量删除成员
     */
    async userBatchDelete(usernames) {
        return await this.doRequest({
            method: 'POST',
            path: `user/batch_delete`,
            payload: {
                usernames
            }
        });
    }

    /**
    * 批量导入成员
    */
    async userImport(users) {
        return await this.doRequest({
            method: 'POST',
            path: `/user/import`,
            payload: {
                users
            }
        });
    }
}
