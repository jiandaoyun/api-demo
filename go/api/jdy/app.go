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
)

// AppApiClient 应用Api
type AppApiClient struct {
	*base.ApiClient
}

func (api *AppApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
	}[version]
}

func (api *AppApiClient) DefaultVersion() string {
	return "v1"
}

// DoRequest 发送http请求
func (api *AppApiClient) DoRequest(method string, path string, query map[string]string, payload []byte) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(method, path, query, payload)
}

// AppList 应用列表
func (api *AppApiClient) AppList(skip, limit uint8) (responseBody model.AppList, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"skip":  skip,
		"limit": limit,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest("POST", "/app/retrieve_all", nil, payload)
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
