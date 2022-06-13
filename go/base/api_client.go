/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package base

import (
	"bytes"
	"context"
	"encoding/json"
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

// Api 抽象
type Api interface {
	ValidVersion(version string) bool
	DefaultVersion() string
}

// ApiClient 基类
type ApiClient struct {
	Host    string
	ApiKey  string
	Version string
}

// RequestOption 请求选项
type RequestOption struct {
	Version string
	Method  string
	Path    string
	Query   map[string]string
	Payload []byte
}

// DoRequest 发送http请求
func (api *ApiClient) DoRequest(option *RequestOption) (responseBody []byte, err error) {
	// request
	timeout, cancelFunc := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancelFunc()
	if option.Version == "" {
		option.Version = api.Version
	}
	request, err := http.NewRequestWithContext(
		timeout,
		strings.ToUpper(option.Method),
		fmt.Sprintf("%s/%s/%s", api.Host, option.Version, option.Path),
		bytes.NewBuffer(option.Payload))
	if err != nil {
		log.Println(err.Error())
		return
	}
	request.Header.Set("Authorization", fmt.Sprintf("Bearer %s", api.ApiKey))
	request.Header.Set("Content-type", "application/json;charset=utf-8")
	if option.Query != nil && len(option.Query) > 0 {
		values := new(url.Values)
		for k, v := range option.Query {
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

// JsonIndentString json换行缩进字符串
func JsonIndentString(v interface{}) string {
	indent, _ := json.MarshalIndent(v, "", "    ")
	return string(indent)
}
