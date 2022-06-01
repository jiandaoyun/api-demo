# fxpub-api-demo/go

简道云 openApi 调用示例 golang 版本

* 编码环境如下

```shell
$ go version
go version go1.17 linux/amd64
```

## src

* api/arch: 组织架构相关API
* api/jdy: 简道云表单, 数据等API
* base: 基类

## test

* 用户修改 `base/api_client.go` 内的ApiKey和Host进行测试
* `go test ./... -v`
