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

func TestWorkflowApi(t *testing.T) {
	api := new(WorkflowApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("SingleDataCreate", func(t *testing.T) {
		_, err := api.ApprovalComments(AppId, EntryId, DataId, map[string]interface{}{})
		assert.NotNil(t, err)
		t.Log(err)
	})
}
