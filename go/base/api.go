/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package base

import (
	"bytes"
	"context"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
	"strings"
	"time"
)

const ApiKey = "TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp"
const Host = "https://api.jiandaoyun.com/api"
const DefaultVersion = "v1"

// ApiClient 基类
type ApiClient struct {
	Host    string
	ApiKey  string
	Version string
}

// DoRequest 发送http请求
func (api *ApiClient) DoRequest(method string, path string, query map[string]string, payload []byte) (responseBody []byte, err error) {
	if api.Version == "" {
		api.Version = DefaultVersion
	}

	// request
	timeout, cancelFunc := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancelFunc()
	request, err := http.NewRequestWithContext(
		timeout,
		strings.ToUpper(method),
		fmt.Sprintf("%s/%s/%s", api.Host, api.Version, path),
		bytes.NewBuffer(payload))
	if err != nil {
		log.Println(err.Error())
		return
	}
	request.Header.Set("Authorization", fmt.Sprintf("Bearer %s", api.ApiKey))
	request.Header.Set("Content-type", "application/json;charset=utf-8")
	if query != nil && len(query) > 0 {
		values := new(url.Values)
		for k, v := range query {
			values.Add(k, v)
		}
		request.URL.RawQuery = values.Encode()
	}

	DefaultLimiter.TryBeforeRun()
	// response
	response, err := http.DefaultClient.Do(request)
	if err != nil {
		return
	}
	defer response.Body.Close()

	return ioutil.ReadAll(response.Body)
}
