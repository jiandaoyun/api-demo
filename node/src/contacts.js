/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/17
 */
import { Api } from './api';

export class ContactsApi extends Api {
    /**
     * 1.部门管理
     */

    /**
     * （递归）获取部门列表
     */
    async deptList(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/${deptNo}/department_list`,
            payload: {
                has_child: true
            }
        });
    }

    /**
     * 创建部门
     */
    async deptCreate() {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/create`,
            payload: {
                name: '研发部门',
                // parent_no: 1,
                // dept_no: 2
            }
        });
    }

    /**
     * 更新部门
     */
    async deptUpdate(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/${deptNo}/update`,
            payload: {
                name: '测试部门'
            }
        });
    }

    /**
     * 删除部门
     */
    async deptDelete(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/${deptNo}/delete`
        });
    }

    /**
     * 根据集成模式通讯录的部门ID获取部门编号
     */
    async deptByIntegrateId(integrateId) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/get_deptno_by_integrateid`,
            payload: {
                integrate_id: integrateId
            }
        });
    }

    /**
     * 2.成员管理
     */

    /**
     * 获取部门成员（递归）
     */
    async deptMemberList(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/${deptNo}/member_list`,
            payload: {
                has_child: true
            }
        });
    }

    /**
     * 获取成员
     */
    async userInfo(username) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/user/${username}/user_retrieve`
        });
    }

    /**
     * 创建成员
     */
    async userCreate() {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/user/create`,
            payload: {
                name: '小云',
                // departments: [1, 3],
                username: 'jiandaoyun'
            }
        });
    }

    /**
     * 更新成员
     */
    async userUpdate(username) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/user/${username}/update`,
            payload: {
                name: '小简',
                // departments: [4]
            }
        });
    }

    /**
     * 删除成员
     */
    async userDelete(username) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/user/${username}/delete`
        });
    }

    /**
     * 批量删除成员
     */
    async userBatchDelete(usernames) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/user/batch_delete`,
            payload: {
                usernames
            }
        });
    }

    /**
     * 3.角色管理
     */

    /**
     * 4. 批量管理
     */

    /**
     * 企业互联
     */
}
