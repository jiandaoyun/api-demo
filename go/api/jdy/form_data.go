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

// FormDataApiClient 表单数据Api
type FormDataApiClient struct {
	*base.ApiClient
}

func (api *FormDataApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
		"v2": true,
		"v3": true,
		"v4": true,
	}[version]
}

func (api *FormDataApiClient) DefaultVersion() string {
	return "v4"
}

// DoRequest 发送http请求
func (api *FormDataApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// SingleDataCreate 新建单条数据接口
func (api *FormDataApiClient) SingleDataCreate(appId, entryId string, data, option map[string]interface{}) (responseBody *model.FormData, err error) {
	option["data"] = data
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_create", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// SingleDataQuery 查询单条数据接口
func (api *FormDataApiClient) SingleDataQuery(appId, entryId, dataId string) (responseBody *model.FormData, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"data_id": dataId,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_retrieve", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// SingleDataUpdate 修改单条数据接口
func (api *FormDataApiClient) SingleDataUpdate(appId, entryId, dataId string, data, option map[string]interface{}) (responseBody *model.FormData, err error) {
	option["data"] = data
	option["data_id"] = dataId
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_update", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// SingleDataRemove 删除单条数据接口
func (api *FormDataApiClient) SingleDataRemove(appId, entryId, dataId string, option map[string]interface{}) (responseBody *model.Response, err error) {
	option["data_id"] = dataId
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Version: "v1",
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_delete", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// BatchDataCreate 新建多条数据接口
func (api *FormDataApiClient) BatchDataCreate(appId, entryId string, dataList []map[string]interface{}, option map[string]interface{}) (responseBody *model.BatchResponse, err error) {
	option["data_list"] = dataList
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Version: "v1",
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_batch_create", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// BatchDataQuery 查询多条数据接口
func (api *FormDataApiClient) BatchDataQuery(appId, entryId string, option map[string]interface{}) (responseBody *model.FormDataList, err error) {
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Version: "v1",
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// BatchDataUpdate 修改多条数据接口
func (api *FormDataApiClient) BatchDataUpdate(appId, entryId string, dataIds []string, data map[string]interface{}, option map[string]interface{}) (responseBody *model.BatchResponse, err error) {
	option["data_ids"] = dataIds
	option["data"] = data
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Version: "v1",
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_batch_update", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// BatchDataRemove 删除多条数据接口
func (api *FormDataApiClient) BatchDataRemove(appId, entryId string, dataIds []string) (responseBody *model.BatchResponse, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"data_ids": dataIds,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Version: "v1",
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data_batch_delete", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
