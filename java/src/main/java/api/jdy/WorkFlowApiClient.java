package api.jdy;

import model.flow.WorkFlowApprovalCommentQueryParam;
import model.http.ApiClient;
import model.http.HttpRequestParam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_PATH;

/**
 * 流程表单相关接口
 */
public class WorkFlowApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v1";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v1");

    public WorkFlowApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 获取单条表单流程数据的审批意见
     *
     * @param queryParam - 查询参数信息
     * @return 审批意见
     */
    public Map<String, Object> approvalComments(WorkFlowApprovalCommentQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + APP_BASE_PATH + queryParam.getAppId() + "/entry/"
                + queryParam.getEntryId() + "/data/" + queryParam.getDataId() + "/approval_comments";
        Map<String, Object> data = new HashMap<>();
        data.put("skip", queryParam.getSkip());
        data.put("limit", queryParam.getLimit());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
