package api.jdy;

import model.flow.WorkFlowApprovalCommentQueryParam;

import java.util.Map;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.WORK_FLOW_ENTRY_ID;

public class WorkFlowDemoTest {
    public static void main(String[] args) throws Exception {
        WorkFlowDemo workFlowDemo = new WorkFlowDemo();
        // 获取单条表单流程数据的审批意见
        approvalComments(workFlowDemo);
    }

    private static void approvalComments(WorkFlowDemo workFlowDemo) throws Exception {
        WorkFlowApprovalCommentQueryParam queryParam = new WorkFlowApprovalCommentQueryParam();
        queryParam.setAppId(APP_ID);
        queryParam.setEntryId(WORK_FLOW_ENTRY_ID);
        queryParam.setDataId("62a698af7b6726000713e888");
        queryParam.setLimit(10);
        queryParam.setSkip(0);
        Map<String, Object> result = workFlowDemo.approvalComments(queryParam);
        System.out.println("approvalComments result \n" + result);
    }
}
