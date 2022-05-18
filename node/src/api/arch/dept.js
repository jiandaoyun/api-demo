/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { Api } from '../../base/api';

export class DeptApi extends Api {
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
    async deptCreate(name, parent_no, dept_no) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/create`,
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
    async deptUpdate(deptNo,name) {
        return await this.doRequest({
            method: 'POST',
            path: `/v2/department/${deptNo}/update`,
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
}
