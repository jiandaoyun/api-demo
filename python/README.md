# fxpub-api-demo/python

简道云 openApi 调用示例 python 版本。

演示工程使用了第三方的 requests 框架，经过 Python 3.x 环境测试。

使用前首先安装相关依赖(推荐使用 virtualenv 配置测试环境)：
```angular2html
pip install -r requirements.txt
```

## main
- src/api/arch: 组织架构相关API
- src/api/jdy: 简道云表单,数据等API
- src/constants: 常量
- src/model: 接口用到的实体
- src/util: HTTP工具类和限流工具类

## test
- 测试前用户需修改 `src/constants/http_constant.py` 内的 API_KEY
- src/test 模块下 是 测试代码
