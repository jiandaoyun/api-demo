/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

// TokenAndURL 文件上传凭证和上传地址
type TokenAndURL struct {
	URL   string `json:"url"`
	Token string `json:"token"`
}

// TokenAndURLList 文件上传凭证和上传地址列表
type TokenAndURLList struct {
	TokenAndURLList []TokenAndURL `json:"token_and_url_list"`
}

// FileKey 文件上传后的key
type FileKey struct {
	Key string `json:"key"`
}
