/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package model

// App 应用
type App struct {
	AppId string `json:"app_id"`
	Name  string `json:"name"`
}

// AppList 应用列表
type AppList struct {
	Apps []App `json:"apps"`
}

// Entry 表单
type Entry struct {
	Name    string `json:"name"`
	AppId   string `json:"app_id"`
	EntryId string `json:"entry_id"`
}

// EntryList 表单列表
type EntryList struct {
	Forms []Entry `json:"forms"`
}
