from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from src.model.http.api_client import ApiClient

# 合法的版本
valid_versions = ('v4', 'v3', 'v2', 'v1')
# 默认版本
default_version = 'v4'


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
        url = HttpConstant.DATA_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                           version=self.getValidVersion(version), suffix='data_create')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)

    """
    查询单条数据接口
    Arguments:
        appId: str 应用id
        entry_id: str 表单id
        data_id: str 数据id
        version: 版本
    """

    def singleDataQuery(self, app_id, entry_id, data_id, version=default_version):
        url = HttpConstant.DATA_URL.format(app_id=app_id, entry_id=entry_id,
                                           version=self.getValidVersion(version), suffix='data_retrieve')
        request_param = HttpRequestParam(url, {'data_id': data_id})
        return self.send_post(request_param)

    """
    修改单条数据接口
    Arguments:
        param: FormDataUpdateParam 实例
        version: 版本
    """

    def singleDataUpdate(self, param, version=default_version):
        url = HttpConstant.DATA_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                           version=self.getValidVersion(version), suffix='data_update')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)

    """
    刪除单条数据接口
    Arguments:
        param: FormDataDeleteParam 实例
        version: 版本
    """

    def singleDataRemove(self, param):
        url = HttpConstant.DATA_V1_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                              suffix='data_delete')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)

    """
    新建多条数据接口
    Arguments:
        param: FormDataBatchCreateParam 实例
        version: 版本
    """

    def batchDataCreate(self, param):
        url = HttpConstant.DATA_V1_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                              suffix='data_batch_create')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)

    """
    查询多条数据接口
    Arguments:
        param: FormDataQueryParam 实例
        version: 版本
    """

    def batchDataQuery(self, param):
        url = HttpConstant.DATA_V1_URL.format(app_id=param.app_id, entry_id=param.entry_id, suffix='data')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)

    """
    删除多条数据接口
    Arguments:
        param: FormDataDeleteParam 实例
        version: 版本

    """

    def batchDataRemove(self, param):
        url = HttpConstant.DATA_V1_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                              suffix='data_batch_delete')
        request_param = HttpRequestParam(url, {'data_ids': param.data_ids})
        return self.send_post(request_param)

    """
    修改多条数据接口
    Arguments:
        param:FormDataBatchUpdateParam 实例
        version: 版本
    """

    def batchDataUpdate(self, param):
        url = HttpConstant.DATA_V1_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                              suffix='data_batch_update')
        request_param = HttpRequestParam(url, param)
        return self.send_post(request_param)
