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
	"fmt"
)

// MemberApiClient 成员Api
type MemberApiClient struct {
	*base.ApiClient
}

func (api *MemberApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
		"v2": true,
	}[version]
}

func (api *MemberApiClient) DefaultVersion() string {
	return "v2"
}

// DoRequest 发送http请求
func (api *MemberApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// DeptMemberList 获取部门成员（递归）
func (api *MemberApiClient) DeptMemberList(deptNo int, options map[string]interface{}) (responseBody *model.MemberList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("department/%d/member_list", deptNo),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserInfo 获取成员
func (api *MemberApiClient) UserInfo(username string) (responseBody *model.MemberResponse, err error) {
	response, err := api.DoRequest(&base.RequestOption{
		Method: "POST",
		Path:   fmt.Sprintf("user/%s/user_retrieve", username),
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserCreate 创建成员
func (api *MemberApiClient) UserCreate(name string, options map[string]interface{}) (responseBody *model.MemberResponse, err error) {
	options["name"] = name
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "user/create",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserUpdate 更新成员
func (api *MemberApiClient) UserUpdate(username string, options map[string]interface{}) (responseBody *model.MemberResponse, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("user/%s/update", username),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserDelete 删除成员
func (api *MemberApiClient) UserDelete(username string) (responseBody *model.Response, err error) {
	response, err := api.DoRequest(&base.RequestOption{
		Method: "POST",
		Path:   fmt.Sprintf("user/%s/delete", username),
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserBatchDelete 批量删除成员
func (api *MemberApiClient) UserBatchDelete(usernames []string) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"usernames": usernames,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "user/batch_delete",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UserImport 批量导入成员
func (api *MemberApiClient) UserImport(users []model.Member) (responseBody *model.Response, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"users": users,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "user/import",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
