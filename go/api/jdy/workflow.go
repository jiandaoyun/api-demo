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

// WorkflowApiClient 流程Api
type WorkflowApiClient struct {
	*base.ApiClient
}

func (api *WorkflowApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
	}[version]
}

func (api *WorkflowApiClient) DefaultVersion() string {
	return "v1"
}

// DoRequest 发送http请求
func (api *WorkflowApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// ApprovalComments 获取单条表单流程数据的审批意见
func (api *WorkflowApiClient) ApprovalComments(appId, entryId, dataId string, option map[string]interface{}) (responseBody *model.ApprovalCommentList, err error) {
	payload, err := json.Marshal(option)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/data/%s/approval_comments", appId, entryId, dataId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
