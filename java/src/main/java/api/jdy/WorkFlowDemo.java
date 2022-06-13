package api.jdy;

import constants.HttpConstant;
import model.flow.WorkFlowApprovalCommentQueryParam;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_URL;

public class WorkFlowDemo {

    /**
     * 获取单条表单流程数据的审批意见
     *
     * @param queryParam
     * @throws Exception
     */
    public Map<String, Object> approvalComments(WorkFlowApprovalCommentQueryParam queryParam) throws Exception {
        if (StringUtils.isBlank(queryParam.getAppId()) || StringUtils.isBlank(queryParam.getEntryId())
                || StringUtils.isBlank(queryParam.getDataId())) {
            throw new RuntimeException("param lack!");
        }
        String url = APP_BASE_URL + queryParam.getAppId() + "/entry/" + queryParam.getEntryId()
                + "/data/" + queryParam.getDataId() + "/approval_comments";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("skip", queryParam.getSkip());
        data.put("limit", queryParam.getLimit());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }
}
