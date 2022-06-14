/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

// RoleGroup 角色组
type RoleGroup struct {
	GroupNo     int    `json:"group_no"`
	Name        string `json:"name"`
	Type        int    `json:"type"`
	IntegrateId string `json:"integrate_id"`
}

// RoleGroupList 角色组列表
type RoleGroupList struct {
	RoleGroups []RoleGroup `json:"role_groups"`
}

// RoleGroupResponse 角色组响应
type RoleGroupResponse struct {
	RoleGroup `json:"role_group"`
}
