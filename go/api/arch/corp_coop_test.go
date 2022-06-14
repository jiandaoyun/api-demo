/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package arch

import (
	"api-demo/base"
	"testing"
)

func TestCorpCoopApi(t *testing.T) {
	api := new(CorpCoopApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("CorpCoopDepartList", func(t *testing.T) {
		corpCoopDepartList, err := api.CorpCoopDepartList(map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(corpCoopDepartList))
		}
	})
}
