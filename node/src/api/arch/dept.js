/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/05/18
 */

import { ApiClient } from '../../base/api_client';
import { DEPT_BASE_PATH } from '../../constants/http_constant'


export class DeptApiClient extends ApiClient {
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
     * （递归）获取部门列表
     */
    async deptList(deptNo, options) {
        return await this.doRequest({
            method: 'POST',
            path: DEPT_BASE_PATH + 'list',
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
            path: DEPT_BASE_PATH + 'create',
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
    async deptUpdate(dept_no, name) {
        return await this.doRequest({
            method: 'POST',
            path: DEPT_BASE_PATH + 'update',
            payload: {
                dept_no,
                name
            }
        });
    }

    /**
     * 删除部门
     */
    async deptDelete(dept_no) {
        return await this.doRequest({
            method: 'POST',
            path: DEPT_BASE_PATH + 'delete',
            payload: {
                dept_no
            }
        });
    }

    /**
     * 根据集成模式通讯录的部门ID获取部门编号
     */
    async deptByIntegrateId(integrateId) {
        return await this.doRequest({
            method: 'POST',
            path: DEPT_BASE_PATH + 'dept_no/get',
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
            path: DEPT_BASE_PATH + 'import',
            payload: {
                departments
            }
        });
    }
}
