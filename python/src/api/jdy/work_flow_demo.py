from ...util import http_util as http_util
from ...constants.http_constant import HttpConstant
from ...model.http.http_request_param import HttpRequestParam


"""
获取单条表单流程数据的审批意见
Arguments:
    work_flow_query_param: WorkFlowApprovalCommentQueryParam 实例
"""

def approvalComments(work_flow_query_param):
    url = HttpConstant.APP_BASE_URL + work_flow_query_param.app_id + "/entry/" + work_flow_query_param.entry_id
    url = url + "/data/" + work_flow_query_param.data_id + "/approval_comments"
    query_param = {'limit': work_flow_query_param.limit, 'skip': work_flow_query_param.skip}
    request_param = HttpRequestParam(HttpConstant.API_KEY, url, query_param)
    return http_util.send_post(request_param)

