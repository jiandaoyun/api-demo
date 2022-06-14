/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/13
 */

package model

// Response 请求结果
type Response struct {
	Status string `json:"status"`
}

// BatchResponse 批量请求结果
type BatchResponse struct {
	Status       string   `json:"status"`
	SuccessCount int      `json:"success_count"`
	SuccessIds   []string `json:"success_ids"`
}
