/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/13
 */

package model

// Member 成员
type Member struct {
	Id          string `json:"_id"`
	Username    string `json:"username"`
	Name        string `json:"name"`
	Type        int    `json:"type"`
	Status      int    `json:"status"`
	Departments []int  `json:"departments"`
}

// MemberList 成员列表
type MemberList struct {
	Users []Member `json:"users"`
}

// MemberResponse 成员返回
type MemberResponse struct {
	User Member `json:"user"`
}
