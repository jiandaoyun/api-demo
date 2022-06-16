from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam

"""
获取单条表单流程数据的审批意见
Arguments:
    work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
"""


def approvalComments(param):
    url = HttpConstant.APPROVAL_COMMENTS_URL.format(appId=param.app_id, entryId=param.entry_id, dataId=param.data_id)
    print('url ====' + url)
    query_param = {'limit': param.limit, 'skip': param.skip}
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, query_param)
    return http_util.send_post(request_param)
