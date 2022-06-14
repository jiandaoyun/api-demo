/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package jdy

import (
	"api-demo/base"
	"api-demo/model"
	"encoding/json"
	"fmt"
)

// FormApiClient 表单Api
type FormApiClient struct {
	*base.ApiClient
}

func (api *FormApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
		"v2": true,
	}[version]
}

func (api *FormApiClient) DefaultVersion() string {
	return "v2"
}

// DoRequest 发送http请求
func (api *FormApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// FormWidgets 表单字段查询接口
func (api *FormApiClient) FormWidgets(appId, entryId string) (responseBody *model.FormWidgets, err error) {
	response, err := api.DoRequest(&base.RequestOption{
		Method: "POST",
		Path:   fmt.Sprintf("app/%s/entry/%s/widgets", appId, entryId),
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
