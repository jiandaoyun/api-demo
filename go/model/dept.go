/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

// Dept 部门
type Dept struct {
	DeptNo   int    `json:"dept_no"`
	Name     string `json:"name"`
	ParentNo int    `json:"parent_no"`
}

// DeptList 部门列表
type DeptList struct {
	Departments []Dept `json:"departments"`
}

// DeptResponse 部门响应
type DeptResponse struct {
	Department Dept `json:"department"`
}
