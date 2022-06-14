/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package jdy

import (
	"api-demo/base"
	"api-demo/model"
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"io/ioutil"
	"mime/multipart"
	"net/http"
	"os"
)

// FileApiClient 文件Api
type FileApiClient struct {
	*base.ApiClient
}

func (api *FileApiClient) ValidVersion(version string) bool {
	return map[string]bool{
		"v1": true,
	}[version]
}

func (api *FileApiClient) DefaultVersion() string {
	return "v1"
}

// DoRequest 发送http请求
func (api *FileApiClient) DoRequest(option *base.RequestOption) (responseBody []byte, err error) {
	if !api.ValidVersion(api.Version) {
		api.Version = api.DefaultVersion()
	}
	return api.ApiClient.DoRequest(option)
}

// UploadToken 获取文件上传凭证和上传地址接口
func (api *FileApiClient) UploadToken(appId, entryId, transactionId string) (responseBody *model.TokenAndURLList, err error) {
	payload, err := json.Marshal(map[string]interface{}{
		"transaction_id": transactionId,
	})
	if err != nil {
		return
	}

	response, err := api.DoRequest(&base.RequestOption{
		Method:  "POST",
		Path:    fmt.Sprintf("app/%s/entry/%s/file/get_upload_token", appId, entryId),
		Payload: payload,
	})
	if err != nil {
		return
	}

	err = json.Unmarshal(response, &responseBody)
	return
}

// UploadFile 文件上传接口
func (api *FileApiClient) UploadFile(url, token string, file *os.File) (responseBody *model.FileKey, err error) {
	body := new(bytes.Buffer)
	writer := multipart.NewWriter(body)

	writer.WriteField("token", token)
	w, err := writer.CreateFormFile("file", file.Name())
	if err != nil {
		return
	}
	_, err = io.Copy(w, file)
	if err != nil {
		return
	}
	writer.Close()

	req, err := http.NewRequest(http.MethodPost, url, body)
	if err != nil {
		return
	}
	req.Header.Set("Content-Type", writer.FormDataContentType())

	response, err := http.DefaultClient.Do(req)
	if err != nil {
		return
	}
	defer response.Body.Close()

	r, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return
	}

	if response.StatusCode != http.StatusOK {
		err = fmt.Errorf("request fail, response code: %d, response body: %s", response.StatusCode, string(r))
		return
	}

	err = json.Unmarshal(r, &responseBody)
	return
}
