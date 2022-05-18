/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package _go

import (
	"encoding/json"
	"testing"
)

const ApiKey = "TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp"
const Host = "https://api.jiandaoyun.com/api"

// JsonIndentString json换行缩进字符串
func JsonIndentString(v interface{}) string {
	indent, _ := json.MarshalIndent(v, "", "    ")
	return string(indent)
}

func TestApplicationApi(t *testing.T) {
	api := new(ApplicationApi)
	api.Api = &Api{ApiKey: ApiKey, Host: Host}

	t.Run("AppList", func(t *testing.T) {
		list, err := api.AppList()
		if err != nil {
			t.Error(err)
		} else {
			t.Log(JsonIndentString(list))
		}
	})
}
