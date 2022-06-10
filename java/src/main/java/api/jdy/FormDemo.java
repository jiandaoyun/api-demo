package api.jdy;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.Map;

import static constants.HttpConstant.FORM_BASE_URL;

/**
 * 表单相关的请求demo
 */
public class FormDemo {


    /**
     * 表单字段查询接口
     *
     * @param appId
     * @param entryId
     * @throws Exception
     */
    public Map<String, Object> formWidgets(String appId, String entryId) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId)) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_BASE_URL + appId + "/entry/" + entryId + "/widgets";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }


}
