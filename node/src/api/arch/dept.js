/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';

export class DeptApiClient extends ApiClient {
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
     * （递归）获取部门列表
     */
    async deptList(deptNo, options) {
        return await this.doRequest({
            method: 'POST',
            path: `department/${deptNo}/department_list`,
            payload: {
                has_child: options.hasChild
            }
        });
    }

    /**
     * 创建部门
     */
    async deptCreate(name, options) {
        return await this.doRequest({
            method: 'POST',
            path: `department/create`,
            payload: {
                name,
                parent_no: options.parentNo,
                dept_no: options.deptNo
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

    /**
     * 批量导入部门
     */
    async departmentImport(departments) {
        return await this.doRequest({
            method: 'POST',
            path: `/department/import`,
            payload: {
                departments
            }
        });
    }
}
