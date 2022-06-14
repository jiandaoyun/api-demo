/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/13
 */

package arch

import (
	"api-demo/base"
	"api-demo/model"
	"encoding/json"
)

// RoleGroupApiClient 角色组Api
type RoleGroupApiClient struct {
	*base.ApiClient
}

func (api *RoleGroupApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v2": true,
	}[version]
}

func (api *RoleGroupApiClient) DefaultVersion() string {
	return "v2"
}

// DoRequest 发送http请求
func (api *RoleGroupApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// RoleGroupList 角色组列表
func (api *RoleGroupApiClient) RoleGroupList(options map[string]interface{}) (responseBody *model.RoleGroupList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role_group/list",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleGroupCreate 创建角色组
func (api *RoleGroupApiClient) RoleGroupCreate(name string) (responseBody *model.RoleGroupResponse, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"name": name,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role_group/create",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// REoleGroupUpdate 更新角色组
func (api *RoleGroupApiClient) RoleGroupUpdate(roleGroupNo int, name string) (responseBody *model.RoleGroupResponse, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"role_group_no": roleGroupNo,
		"name":          name,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role_group/update",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleGroupDelete 删除自建角色组
func (api *RoleGroupApiClient) RoleGroupDelete(roleGroupNo int) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"role_group_no": roleGroupNo,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role_group/delete",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
