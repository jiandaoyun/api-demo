/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package arch

import (
	"api-demo/base"
	"api-demo/model"
	"encoding/json"
	"fmt"
)

// DeptApiClient 部门Api
type DeptApiClient struct {
	*base.ApiClient
}

func (api *DeptApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v2": true,
	}[version]
}

func (api *DeptApiClient) DefaultVersion() string {
	return "v2"
}

// DoRequest 发送http请求
func (api *DeptApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// DeptList（递归）获取部门列表
func (api *DeptApiClient) DeptList(deptNo int, options map[string]interface{}) (responseBody *model.DeptList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("department/%d/department_list", deptNo),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// DeptCreate 创建部门
func (api *DeptApiClient) DeptCreate(name string, options map[string]interface{}) (responseBody *model.DeptResponse, err error) {
	options["name"] = name
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "department/create",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// DeptUpdate 更新部门
func (api *DeptApiClient) DeptUpdate(deptNo int, name string) (responseBody *model.DeptResponse, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"name": name,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("department/%d/update", deptNo),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// DeptDelete 删除部门
func (api *DeptApiClient) DeptDelete(deptNo int) (responseBody *model.Response, err error) {
	response, err := api.DoRequest(&base.RequestOption{
		Method: "POST",
		Path:   fmt.Sprintf("department/%d/delete", deptNo),
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// DeptByIntegrateId 根据集成模式通讯录的部门ID获取部门编号
func (api *DeptApiClient) DeptByIntegrateId(integrateId string) (responseBody *model.Dept, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"integrate_id": integrateId,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "department/get_deptno_by_integrateid",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// DepartmentImport 批量导入部门
func (api *DeptApiClient) DepartmentImport(departments []model.Dept) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"departments": departments,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "department/import",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
