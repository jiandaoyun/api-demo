package api.jdy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.form.*;
import model.http.ApiClient;
import model.http.HttpRequestParam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.FORM_DATA_BASE_PATH;

/**
 * 表单数据相关接口
 */
public class FormDataApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v5");

    public FormDataApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + FORM_DATA_BASE_PATH + path;
    }


    /**
     * 新建单条数据接口
     *
     * @param createParam - 表单数据信息
     * @return 新增的数据信息
     */
    public Map<String, Object> singleDataCreate(FormDataCreateParam createParam, String version) throws Exception {
        if (createParam == null || !createParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "create");
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(createParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }


    /**
     * 查询单条数据接口
     *
     * @param queryParam - 查询参数
     * @return 数据信息
     */
    public Map<String, Object> singleDataQuery(FormDataQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isSingleQueryValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "get");
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", queryParam.getDataId());
        data.put("app_id", queryParam.getApp_id());
        data.put("entry_id", queryParam.getEntry_id());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 修改单条数据接口
     *
     * @param updateParam - 更新数据信息
     * @return 更新后的数据信息
     */
    public Map<String, Object> singleDataUpdate(FormDataUpdateParam updateParam, String version) throws Exception {
        if (updateParam == null || !updateParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "update");
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(updateParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }


    /**
     * 刪除单条数据接口
     *
     * @param deleteParam - 删除的数据信息
     * @param version     - 版本
     * @return status
     */
    public Map<String, Object> singleDataRemove(FormDataDeleteParam deleteParam, String version) throws Exception {
        if (deleteParam == null || !deleteParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "delete");
        Map<String, Object> data =
                new ObjectMapper().convertValue(deleteParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 新建多条数据接口
     *
     * @param createParam - 新建的数据信息
     * @param version     - 版本
     * @return success_count
     */
    public Map<String, Object> batchDataCreate(FormDataBatchCreateParam createParam, String version) throws Exception {
        if (createParam == null || !createParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "batch_create");
        Map<String, Object> data =
                new ObjectMapper().convertValue(createParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 查询多条数据接口
     *
     * @param queryParam - 查询参数
     * @param version    - 版本
     * @return 数据信息
     */
    public Map<String, Object> batchDataQuery(FormDataQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "list");
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 删除多条数据接口
     *
     * @param removeParam - 删除参数
     * @param version     - 版本
     * @return status 和 success_count
     */
    public Map<String, Object> batchDataRemove(FormDataBatchRemoveParam removeParam, String version) throws Exception {
        if (removeParam == null || !removeParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "batch_delete");
        Map<String, Object> data =
                new ObjectMapper().convertValue(removeParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 修改多条数据接口
     *
     * @param updateParam - 更新数据的信息
     * @param version     - 版本
     * @return status 和 success_count
     */
    public Map<String, Object> batchDataUpdate(FormDataBatchUpdateParam updateParam, String version) throws Exception {
        if (updateParam == null || !updateParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "batch_update");
        Map<String, Object> data =
                new ObjectMapper().convertValue(updateParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

}
