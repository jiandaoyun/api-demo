package api.jdy;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_URL;


/**
 * 应用请求相关的demo
 */
public class AppDemo {

    /**
     * 应用分页列表
     *
     * @param skip
     * @param limit
     * @throws Exception
     */
    public Map<String, Object> appList(Integer skip, Integer limit) throws Exception {
        if (skip == null || limit == null) {
            throw new RuntimeException("param lack!");
        }
        String url = APP_BASE_URL + "retrieve_all";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("skip", skip);
        data.put("limit", limit);
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        System.out.println("appList result:\n" + result.toString());
        return result;
    }

    /**
     * 表单查询接口 分页
     *
     * @param appId
     * @param skip
     * @param limit
     * @throws Exception
     */
    public Map<String, Object> entryList(String appId, Integer skip, Integer limit) throws Exception {
        if (StringUtils.isBlank(appId) || skip == null || limit == null) {
            throw new RuntimeException("param lack!");
        }
        String url = APP_BASE_URL + appId + "/entry_retrieve";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("skip", skip);
        data.put("limit", limit);
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        System.out.println("entryList result:\n" + result.toString());
        return result;
    }


}
