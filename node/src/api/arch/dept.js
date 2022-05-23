/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';

export class DeptApiClient extends ApiClient {
    /**
     * （递归）获取部门列表
     */
    async deptList(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/department_list`,
            payload: {
                has_child: true
            }
        });
    }

    /**
     * 创建部门
     */
    async deptCreate(name, parent_no, dept_no) {
        return await this.doRequest({
            method: 'POST',
            path: `department/create`,
            payload: {
                name,
                parent_no,
                dept_no
            }
        });
    }

    /**
     * 更新部门
     */
    async deptUpdate(deptNo, name) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/update`,
            payload: {
                name
            }
        });
    }

    /**
     * 删除部门
     */
    async deptDelete(deptNo) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/delete`
        });
    }

    /**
     * 根据集成模式通讯录的部门ID获取部门编号
     */
    async deptByIntegrateId(integrateId) {
        return await this.doRequest({
            method: 'POST',
            path: `department/get_deptno_by_integrateid`,
            payload: {
                integrate_id: integrateId
            }
        });
    }
}
