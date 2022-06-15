# fxpub-api-demo/csharp

简道云 openApi 调用示例 c# 版本

* 编码环境如下

```shell
$ dotnet --info 
.NET SDK (reflecting any global.json):
 Version:   6.0.300
 Commit:    8473146e7d

Runtime Environment:
 OS Name:     ubuntu
 OS Version:  20.04
 OS Platform: Linux
 RID:         ubuntu.20.04-x64
 Base Path:   /usr/share/dotnet/sdk/6.0.300/

Host (useful for support):
  Version: 6.0.5
  Commit:  70ae3df4a6

.NET SDKs installed:
  6.0.300 [/usr/share/dotnet/sdk]

.NET runtimes installed:
  Microsoft.AspNetCore.App 6.0.5 [/usr/share/dotnet/shared/Microsoft.AspNetCore.App]
  Microsoft.NETCore.App 6.0.5 [/usr/share/dotnet/shared/Microsoft.NETCore.App]

To install additional .NET runtimes or SDKs:
  https://aka.ms/dotnet-download
```

## src

* api/arch: 组织架构相关API
* api/jdy: 简道云表单, 数据等API
* base: 基类

## test

* 用户修改 `src/base/Global.cs` 内的ApiKey和Host
* `cd test`
* `dotnet test`
