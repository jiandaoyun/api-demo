from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam
from src.model.http.api_client import ApiClient

# 合法的版本
valid_versions = ('v1')
# 默认版本
default_version = 'v1'


class WorkFlowApiClient(ApiClient):

    def __init__(self, api_key, host):
        ApiClient.__init__(self, api_key, host, valid_versions, default_version)

    """
    获取单条表单流程数据的审批意见
    Arguments:
        work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
        version: 版本
    """

    def approvalComments(self, param, version=default_version):
        url = HttpConstant.APPROVAL_COMMENTS_URL.format(app_id=param.app_id, entry_id=param.entry_id,
                                                        data_id=param.data_id, version=self.getValidVersion(version))
        query_param = {'limit': param.limit, 'skip': param.skip}
        request_param = HttpRequestParam(url, query_param)
        return self.send_post(request_param)
