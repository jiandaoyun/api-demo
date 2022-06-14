import src.api.jdy.work_flow_demo as work_flow_demo
from src.constants.http_constant import HttpConstant
from src.model.flow.work_flow_param import WorkFlowApprovalCommentQueryParam


# 测试 获取单条表单流程数据的审批意见
def approvalComments():
    work_flow_query_param = WorkFlowApprovalCommentQueryParam(HttpConstant.APP_ID, HttpConstant.WORK_FLOW_ENTRY_ID)
    work_flow_query_param.setData_id('62a698af7b6726000713e888')
    work_flow_query_param.setSkip(0)
    work_flow_query_param.setLimit(10)

    result = work_flow_demo.approvalComments(work_flow_query_param)
    print('approvalComments result:', result)


if __name__ == '__main__':
    approvalComments()
