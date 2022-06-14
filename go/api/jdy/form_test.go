/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package jdy

import (
	"api-demo/base"
	"testing"
)

func TestFormApi(t *testing.T) {
	api := new(FormApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("FormWidgets", func(t *testing.T) {
		formWidgets, err := api.FormWidgets(AppId, EntryId)
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(formWidgets))
		}
	})

}
