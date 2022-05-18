/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package _go

import (
	"encoding/json"
)

type ApplicationApi struct {
	*Api
}

func (api *ApplicationApi) AppList() (responseBody map[string]interface{}, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"skip":  0,
		"limit": 10,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest("POST", "/v1/app/retrieve_all", nil, payload)
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}
