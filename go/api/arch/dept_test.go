/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package arch

import (
	"api-demo/base"
	"api-demo/model"
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

var deptNo = math.MinInt

func TestDeptApi(t *testing.T) {
	api := new(DeptApiClient)
	api.ApiClient = &base.ApiClient{
		ApiKey: base.ApiKey,
		Host:   base.Host,
	}

	t.Run("DeptCreate", func(t *testing.T) {
		dept, err := api.DeptCreate("Demo研发部门", map[string]interface{}{})
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(dept))
			deptNo = dept.Department.DeptNo
		}
	})

	t.Run("DeptUpdate", func(t *testing.T) {
		dept, err := api.DeptUpdate(deptNo, "Demo测试部门")
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(dept))
		}
	})

	t.Run("DeptList", func(t *testing.T) {
		deptList, err := api.DeptList(deptNo, map[string]interface{}{
			"hasChild": true,
		})
		if err != nil {
			t.Error(err)
		} else {
			t.Log(base.JsonIndentString(deptList))
		}
	})

	t.Run("DeptDelete", func(t *testing.T) {
		response, err := api.DeptDelete(deptNo)
		if err != nil {
			t.Error(err)
		} else {
			assert.Equal(t, "success", response.Status)
		}
	})

	t.Run("DeptByIntegrateId", func(t *testing.T) {
		_, err := api.DeptByIntegrateId("1005")
		assert.NotNil(t, err)
		t.Log(err)
	})

	t.Run("DeptByIntegrateId", func(t *testing.T) {
		_, err := api.DepartmentImport([]model.Dept{})
		assert.NotNil(t, err)
		t.Log(err)
	})
}
