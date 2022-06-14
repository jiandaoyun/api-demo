/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/13
 */

package arch

import (
	"api-demo/base"
	"testing"
)

func TestRoleApi(t *testing.T) {
	api := new(RoleApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("RoleList", func(t *testing.T) {
		roleList, err := api.RoleList(make(map[string]interface{}))
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(roleList))
		}
	})
}
