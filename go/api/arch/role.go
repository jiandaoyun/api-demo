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

// RoleApiClient 角色Api
type RoleApiClient struct {
	*base.ApiClient
}

func (api *RoleApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v2": true,
	}[version]
}

func (api *RoleApiClient) DefaultVersion() string {
	return "v2"
}

// DoRequest 发送http请求
func (api *RoleApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// RoleList 角色列表
func (api *RoleApiClient) RoleList(options map[string]interface{}) (responseBody *model.RoleList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/list",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleCreate 角色创建
func (api *RoleApiClient) RoleCreate(name string, groupNo int) (responseBody *model.RoleResponse, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"name":     name,
		"group_no": groupNo,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/create",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleUpdate 角色更新
func (api *RoleApiClient) RoleUpdate(roleNo, groupNo int, option map[string]interface{}) (responseBody *model.RoleResponse, err error) {
	option["role_no"] = roleNo
	option["group_no"] = groupNo
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/update",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleDelete 角色删除
func (api *RoleApiClient) RoleDelete(roleNo int) (responseBody map[string]interface{}, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"role_no": roleNo,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/delete",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleMemberList 列出角色下所有成员
func (api *RoleApiClient) RoleMemberList(roleNo int, option map[string]interface{}) (responseBody *model.MemberList, err error) {
	option["role_no"] = roleNo
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/member_list",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleAddMembers 为自建角色批量添加成员
func (api *RoleApiClient) RoleAddMembers(roleNo int, usernames []string) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"role_no":   roleNo,
		"usernames": usernames,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/add_members",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// RoleRmoveMembers 为自建角色批量移除成员
func (api *RoleApiClient) RoleRmoveMembers(roleNo int, usernames []string) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"role_no":   roleNo,
		"usernames": usernames,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "role/remove_members",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
