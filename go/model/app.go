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
