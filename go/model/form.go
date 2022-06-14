/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

type Widget struct {
	Name  string   `json:"name"`
	Label string   `json:"label"`
	Type  string   `json:"type"`
	Items []Widget `json:"items"`
}

type FormWidgets struct {
	Widgets        []Widget `json:"widgets"`
	SysWidgets     []Widget `json:"sysWidgets"`
	DataModifyTime string   `json:"dataModifyTime"`
}
