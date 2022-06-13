package api.arch;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.HttpConstant;
import model.role.RoleGroupListQueryParam;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.ROLE_GROUP_BASE_URL;

/**
 * 角色组 相关的 请求 Demo
 */
public class RoleGroupDemo {

    /**
     * 列出角色组
     *
     * @param queryParam
     * @throws Exception
     */
    public Map<String, Object> roleGroupList(RoleGroupListQueryParam queryParam) throws Exception {
        String url = ROLE_GROUP_BASE_URL + "list";
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
     * 创建角色组
     *
     * @param name
     * @throws Exception
     */
    public Map<String, Object> roleGroupCreate(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_GROUP_BASE_URL + "create";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 更新角色组
     *
     * @param name
     * @param roleGroupNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleGroupUpdate(String name, Integer roleGroupNo) throws Exception {
        if (StringUtils.isBlank(name) || roleGroupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_GROUP_BASE_URL + "update";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("role_group_no", roleGroupNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 删除角色组
     *
     * @param roleGroupNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> roleGroupDelete(Integer roleGroupNo) throws Exception {
        if (roleGroupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = ROLE_GROUP_BASE_URL + "delete";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("role_group_no", roleGroupNo);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

}
