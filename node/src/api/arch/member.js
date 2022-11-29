/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';
import { DEPT_BASE_PATH, MEMBER_BASE_PATH } from '../../constants/http_constant';

export class MemberApiClient extends ApiClient {
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
     * 获取部门成员（递归）
     */
    async deptMemberList(dept_no, options) {
        return await this.doRequest({
            method: 'POST',
            path: DEPT_BASE_PATH + 'user/list',
            payload: {
                has_child: options.hasChild,
                dept_no
            }
        });
    }

    /**
     * 获取成员
     */
    async userInfo(username) {
        return await this.doRequest({
            method: 'POST',
            path: MEMBER_BASE_PATH + 'get',
            payload: {
                username
            }
        });
    }

    /**
     * 创建成员
     */
    async userCreate(name, options) {
        return await this.doRequest({
            method: 'POST',
            path: MEMBER_BASE_PATH + 'create',
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
            path: MEMBER_BASE_PATH + 'update',
            payload: {
                username,
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
            path: MEMBER_BASE_PATH + 'delete',
            payload: {
                username
            }
        });
    }

    /**
     * 批量删除成员
     */
    async userBatchDelete(usernames) {
        return await this.doRequest({
            method: 'POST',
            path: MEMBER_BASE_PATH + 'batch_delete',
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
            path: MEMBER_BASE_PATH + 'import',
            payload: {
                users
            }
        });
    }
}
