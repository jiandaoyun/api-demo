/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package jdy

import (
	"api-demo/base"
	"testing"
)

var AppId = ""
var EntryId = ""

func TestApplicationApi(t *testing.T) {
	api := new(AppApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("AppList", func(t *testing.T) {
		appList, err := api.AppList(make(map[string]interface{}))
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(appList))
			AppId = appList.Apps[0].AppId
		}
	})

	t.Run("EntryList", func(t *testing.T) {
		entryList, err := api.EntryList(AppId, make(map[string]interface{}))
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(entryList))
			EntryId = entryList.Forms[0].EntryId
		}
	})
}
