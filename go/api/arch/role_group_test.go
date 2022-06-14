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

func TestRoleGroupApi(t *testing.T) {
	api := new(RoleGroupApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("RoleGroupList", func(t *testing.T) {
		roleGroupList, err := api.RoleGroupList(make(map[string]interface{}))
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(roleGroupList))
		}
	})
}
