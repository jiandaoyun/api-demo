/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package jdy

import (
	"api-demo/base"
	"encoding/json"
	"testing"
)

// JsonIndentString json换行缩进字符串
func JsonIndentString(v interface{}) string {
	indent, _ := json.MarshalIndent(v, "", "    ")
	return string(indent)
}

func TestApplicationApi(t *testing.T) {
	api := new(AppApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("AppList", func(t *testing.T) {
		appList, err := api.AppList(0, 10)
		if err != nil {
			t.Error(err)
		} else {
			t.Log(JsonIndentString(appList))
		}
	})
}
