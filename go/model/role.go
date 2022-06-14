/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/13
 */

package model

// Role 角色
type Role struct {
	RoleNo      int    `json:"role_no"`
	GroupNo     int    `json:"group_no"`
	Name        string `json:"name"`
	Type        int    `json:"type"`
	IntegrateId string `json:"integrate_id"`
}

// RoleList 角色列表
type RoleList struct {
	Roles []Role `json:"roles"`
}

// RoleResponse 角色响应
type RoleResponse struct {
	Role `json:"role"`
}
