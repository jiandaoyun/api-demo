/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package arch

import (
	"api-demo/base"
	"api-demo/model"
	"testing"

	"github.com/stretchr/testify/assert"
)

const RootDeptNo = 1

var UserName = ""

func TestMemberApi(t *testing.T) {
	api := new(MemberApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("DeptMemberList", func(t *testing.T) {
		deptMemberList, err := api.DeptMemberList(RootDeptNo, map[string]interface{}{
			"hasChild": true,
		})
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(deptMemberList))
		}
	})

	t.Run("UserCreate", func(t *testing.T) {
		user, err := api.UserCreate("小云", map[string]interface{}{
			"username": "jiandaoyun",
		})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "小云", user.User.Name)
			assert.Equal(t, "jiandaoyun", user.User.Username)
			t.Log(base.JsonIndentString(user))
			UserName = user.User.Username
		}
	})

	t.Run("UserInfo", func(t *testing.T) {
		user, err := api.UserInfo(UserName)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "小云", user.User.Name)
			assert.Equal(t, "jiandaoyun", user.User.Username)
			t.Log(base.JsonIndentString(user))
		}
	})

	t.Run("UserUpdate", func(t *testing.T) {
		user, err := api.UserUpdate(UserName, map[string]interface{}{
			"name": "小简",
		})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "小简", user.User.Name)
			t.Log(base.JsonIndentString(user))
		}
	})

	t.Run("UserDelete", func(t *testing.T) {
		response, err := api.UserDelete(UserName)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
		}
	})

	t.Run("UserBatchDelete", func(t *testing.T) {
		response, err := api.UserBatchDelete([]string{UserName})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
		}
	})

	t.Run("UserImport", func(t *testing.T) {
		response, err := api.UserImport([]model.Member{})
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
		}
	})
}
