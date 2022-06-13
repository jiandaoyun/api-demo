package api.arch;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.CORP_COOP_BASE_URL;

/**
 * 企业互联相关接口
 */
public class CorpCoopDemo {

    /**
     * 列出我连接的企业
     *
     * @param deptNo 部门编号 可为null
     * @throws Exception
     */
    public Map<String, Object> corpCoopDepartList(Integer deptNo) throws Exception {
        String url = CORP_COOP_BASE_URL + "guest/department_list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("dept_no", deptNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 列出我连接的企业对接人
     *
     * @param deptNo 部门编号 可为null
     * @throws Exception
     */
    public Map<String, Object> corpCoopMemberList(Integer deptNo) throws Exception {
        String url = CORP_COOP_BASE_URL + "guest/member_list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("dept_no", deptNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }


    /**
     * 列出我连接的企业对接人详细信息
     *
     * @param userName 用户名
     * @throws Exception
     */
    public Map<String, Object> corpCoopUserInfo(String userName) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String url = CORP_COOP_BASE_URL + "guest/user_retrieve";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("username", userName);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }


}
