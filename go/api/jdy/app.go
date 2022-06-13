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
func (api *AppApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// AppList 应用列表
func (api *AppApiClient) AppList(option map[string]interface{}) (responseBody *model.AppList, err error) {
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "app/retrieve_all",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// EntryList 应用列表
func (api *AppApiClient) EntryList(appId string, option map[string]interface{}) (responseBody *model.EntryList, err error) {
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry_retrieve", appId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
