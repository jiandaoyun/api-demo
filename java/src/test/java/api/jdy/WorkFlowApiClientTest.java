package api.jdy;

import constants.HttpConstant;
import model.flow.WorkFlowApprovalCommentQueryParam;

import java.util.Map;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.WORK_FLOW_ENTRY_ID;

/**
 * 流程表单相关接口测试
 */
public class WorkFlowApiClientTest {

    private static final WorkFlowApiClient workFlowApiClient = new WorkFlowApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 获取单条表单流程数据的审批意见
        approvalComments();
    }

    private static void approvalComments() throws Exception {
        WorkFlowApprovalCommentQueryParam queryParam = new WorkFlowApprovalCommentQueryParam();
        queryParam.setAppId(APP_ID);
        queryParam.setEntryId(WORK_FLOW_ENTRY_ID);
        queryParam.setDataId("637edcbd04fc34000749aff8");
        queryParam.setLimit(10);
        queryParam.setSkip(0);
        Map<String, Object> result = workFlowApiClient.approvalComments(queryParam, null);
        System.out.println("approvalComments result \n" + result);
    }
}
