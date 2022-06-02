# fxpub-api-demo/node

简道云 openApi 调用示例 node 版本

* 编码环境

```shell
$ node --version
v14.18.2
$ npm --version
6.14.17
```

## src

* api/arch: 组织架构相关API
* api/jdy: 简道云表单, 数据等API
* base: 基类

## test

* 用户修改 `src/base/api_client.js` 内的ApiKey和Host
* `npm install`
* `npm run test`
