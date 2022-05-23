/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';

export class MemberApiClient extends ApiClient {

    /**
     * 获取部门成员（递归）
     */
    async deptMemberList(deptNo, has_child) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/member_list`,
            payload: {
                has_child
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
    async userCreate(name, departments, username) {
        return await this.doRequest({
            method: 'POST',
            path: `user/create`,
            payload: {
                name,
                departments,
                username
            }
        });
    }

    /**
     * 更新成员
     */
    async userUpdate(username, name, departments) {
        return await this.doRequest({
            method: 'POST',
            path: `user/${username}/update`,
            payload: {
                name,
                departments
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
}
