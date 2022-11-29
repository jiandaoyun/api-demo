from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from src.model.http.api_client import ApiClient

# 合法的版本
valid_versions = ('v5')
# 默认版本
default_version = 'v5'


class FormDataApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    新建单条数据接口
    Arguments:
        param: FormDataCreateParam 实例
        version: 版本
    """

    def singleDataCreate(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version), suffix='create')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    查询单条数据接口
    Arguments:
        param: 查询参数 FormDataQueryParam实例
        version: 版本
    """

    def singleDataQuery(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version), suffix='get')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    修改单条数据接口
    Arguments:
        param: FormDataUpdateParam 实例
        version: 版本
    """

    def singleDataUpdate(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version), suffix='update')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    刪除单条数据接口
    Arguments:
        param: FormDataDeleteParam 实例
        version: 版本
    """

    def singleDataRemove(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version),
                                                  suffix='delete')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    新建多条数据接口
    Arguments:
        param: FormDataBatchCreateParam 实例
        version: 版本
    """

    def batchDataCreate(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version),
                                                  suffix='batch_create')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    查询多条数据接口
    Arguments:
        param: FormDataQueryParam 实例
        version: 版本
    """

    def batchDataQuery(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version), suffix='list')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    删除多条数据接口
    Arguments:
        param: FormDataDeleteParam 实例
        version: 版本

    """

    def batchDataRemove(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version),
                                                  suffix='batch_delete')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)

    """
    修改多条数据接口
    Arguments:
        param:FormDataBatchUpdateParam 实例
        version: 版本
    """

    def batchDataUpdate(self, param, version=default_version):
        path = HttpConstant.FORM_DATA_PATH.format(version=self.getValidVersion(version),
                                                  suffix='batch_update')
        request_param = HttpRequestParam(path, param)
        return self.send_post(request_param)
