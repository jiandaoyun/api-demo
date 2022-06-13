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
