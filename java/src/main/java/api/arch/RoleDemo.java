package api.arch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.HttpConstant;
import model.role.RoleListQueryParam;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.ROLE_BASE_URL;

/**
 * 角色 相关的 请求 Demo
 */
public class RoleDemo {

    /**
     * 列出角色
     *
     * @param queryParam
     * @throws Exception
     */
    public Map<String, Object> roleList(RoleListQueryParam queryParam) throws Exception {
        String url = ROLE_BASE_URL + "list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data = new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
        });
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 创建角色
     *
     * @param name
     * @param groupNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleCreate(String name, Integer groupNo) throws Exception {
        if (StringUtils.isBlank(name) || groupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "create";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("group_no", groupNo);
        data.put("name", name);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 更新角色
     *
     * @param name
     * @param groupNo
     * @param roleNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleUpdate(String name, Integer groupNo, Integer roleNo) throws Exception {
        if (StringUtils.isBlank(name) || groupNo == null || roleNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "create";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("group_no", groupNo);
        data.put("name", name);
        data.put("role_no", roleNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 删除角色
     *
     * @param roleNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleDelete(Integer roleNo) throws Exception {
        if (roleNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "delete";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 列出角色下的所有成员
     *
     * @param roleNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleMemberList(Integer roleNo, Integer skip, Integer limit) throws Exception {
        if (roleNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "member_list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        data.put("skip", skip);
        data.put("limit", limit);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 批量给已有的成员设置自建角色
     *
     * @param roleNo
     * @param userNameList
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleAddMembers(Integer roleNo, List<String> userNameList) throws Exception {
        if (roleNo == null || userNameList == null || userNameList.size() <= 0) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "add_members";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        data.put("usernames", userNameList);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 为自建角色批量移除成员
     *
     * @param roleNo
     * @param userNameList
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleRmoveMembers(Integer roleNo, List<String> userNameList) throws Exception {
        if (roleNo == null || userNameList == null || userNameList.size() <= 0) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_BASE_URL + "remove_members";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        data.put("usernames", userNameList);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

}
