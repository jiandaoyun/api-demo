/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

// FormData 表单数据
type FormData struct {
	Data map[string]interface{} `json:"data"`
}

// FormDataList 多条表单数据
type FormDataList struct {
	Data []map[string]interface{} `json:"data"`
}
