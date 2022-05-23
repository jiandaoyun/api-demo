/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package jdy

import (
	"api-demo/base"
	"encoding/json"
)

type AppApiClient struct {
	*base.ApiClient
}

func (api *AppApiClient) AppList(skip, limit uint8) (responseBody map[string]interface{}, err error) {
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
