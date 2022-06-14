/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */
package jdy

import (
	"api-demo/base"
	"os"
	"testing"

	"github.com/stretchr/testify/assert"
)

const TransactionId = "87cd7d71-c6df-4281-9927-469094395677"

var token = ""
var url = ""

func TestFileApi(t *testing.T) {
	api := new(FileApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("UploadToken", func(t *testing.T) {
		response, err := api.UploadToken(AppId, EntryId, TransactionId)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, 100, len(response.TokenAndURLList))
			token = response.TokenAndURLList[0].Token
			url = response.TokenAndURLList[0].URL
		}
	})

	t.Run("UploadFile", func(t *testing.T) {
		file, err := os.Open("./file")
		assert.Nil(t, err)
		defer file.Close()

		response, err := api.UploadFile(url, token, file)
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(response))
		}
	})
}
