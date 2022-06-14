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

// CorpCoopApiClient 角色Api
type CorpCoopApiClient struct {
	*base.ApiClient
}

func (api *CorpCoopApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v4": true,
	}[version]
}

func (api *CorpCoopApiClient) DefaultVersion() string {
	return "v4"
}

// DoRequest 发送http请求
func (api *CorpCoopApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// CorpCoopDepartList 列出我连接的企业
func (api *CorpCoopApiClient) CorpCoopDepartList(options map[string]interface{}) (responseBody *model.DeptList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "corp_coop/guest/department_list",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// CorpCoopMemberList 列出我连接的企业对接人
func (api *CorpCoopApiClient) CorpCoopMemberList(options map[string]interface{}) (responseBody *model.MemberList, err error) {
	payload, err := json.Marshal(options)
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "corp_coop/guest/member_list",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// CorpCoopUserInfo 列出我连接的企业对接人详细信息
func (api *CorpCoopApiClient) CorpCoopUserInfo(username string) (responseBody *model.Member, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"username": username,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    "corp_coop/guest/user_retrieve",
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
