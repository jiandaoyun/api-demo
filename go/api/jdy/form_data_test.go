/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package jdy

import (
	"api-demo/base"
	"testing"

	"github.com/stretchr/testify/assert"
)

var emptyData = map[string]interface{}{}

var DataId = ""
var DataIds = []string{}

func TestFormDataApi(t *testing.T) {
	api := new(FormDataApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("SingleDataCreate", func(t *testing.T) {
		formData, err := api.SingleDataCreate(AppId, EntryId, emptyData, map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(formData))
			DataId = formData.Data["_id"].(string)
		}
	})

	t.Run("SingleDataQuery", func(t *testing.T) {
		formData, err := api.SingleDataQuery(AppId, EntryId, DataId)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, DataId, formData.Data["_id"])
			t.Log(base.JsonIndentString(formData))
		}
	})

	t.Run("SingleDataUpdate", func(t *testing.T) {
		formData, err := api.SingleDataUpdate(AppId, EntryId, DataId, emptyData, map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, DataId, formData.Data["_id"])
			t.Log(base.JsonIndentString(formData))
		}
	})

	t.Run("SingleDataRemove", func(t *testing.T) {
		response, err := api.SingleDataRemove(AppId, EntryId, DataId, map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
		}
	})

	t.Run("BatchDataCreate", func(t *testing.T) {
		response, err := api.BatchDataCreate(AppId, EntryId,
			[]map[string]interface{}{emptyData, emptyData}, map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
			assert.Equal(t, 2, response.SuccessCount)
			DataIds = response.SuccessIds
		}
	})

	t.Run("BatchDataQuery", func(t *testing.T) {
		response, err := api.BatchDataQuery(AppId, EntryId, map[string]interface{}{
			"limit": 2,
		})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, 2, len(response.Data))
			t.Log(base.JsonIndentString(response))
		}
	})

	t.Run("BatchDataUpdate", func(t *testing.T) {
		response, err := api.BatchDataUpdate(AppId, EntryId, DataIds, emptyData, map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
			assert.Equal(t, 2, response.SuccessCount)
			t.Log(base.JsonIndentString(response))
		}
	})

	t.Run("BatchDataRemove", func(t *testing.T) {
		response, err := api.BatchDataRemove(AppId, EntryId, DataIds)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
			assert.Equal(t, 2, response.SuccessCount)
			t.Log(base.JsonIndentString(response))
		}
	})
}
