/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
 */

package model

type ApprovalComment struct {
	Operator     Member `json:"operator"`
	FlowAction   string `json:"flowAction"`
	Comment      string `json:"comment"`
	FlowNodeName string `json:"flowNodeName"`
	SignatureURL string `json:"signature_url"`
}

type ApprovalCommentList struct {
	ApproveCommentList []ApprovalComment `json:"approveCommentList"`
}
