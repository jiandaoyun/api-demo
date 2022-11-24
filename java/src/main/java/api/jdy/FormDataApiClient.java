package api.jdy;

import model.form.*;
import model.http.ApiClient;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_PATH;
import static constants.HttpConstant.FORM_DATA_BASE_PATH;

/**
 * 表单数据相关的请求接口
 */
public class FormDataApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v4";
    private static final List<String> VALID_VERSION_LIST = Arrays.asList("v4", "v3", "v2", "v1");

    public FormDataApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }


    /**
     * 新建单条数据接口
     *
     * @param createParam
     * @throws Exception
     */
    public Map<String, Object> singleDataCreate(FormDataCreateParam createParam, String version) throws Exception {
        if (createParam == null || !createParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + FORM_DATA_BASE_PATH + createParam.getAppId() + "/entry/"
                + createParam.getEntryId() + "/data_create";
        Map<String, Object> data = new HashMap<>();
        data.put("data", createParam.getData());
        data.put("is_start_workflow", createParam.getIs_start_workflow());
        data.put("is_start_trigger", createParam.getIs_start_trigger());
        data.put("transaction_id", createParam.getTransaction_id());
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
        String path = super.getValidVersion(version) + FORM_DATA_BASE_PATH + queryParam.getAppId()
                + "/entry/" + queryParam.getEntryId() + "/data_retrieve";
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", queryParam.getDataId());
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
        String path = super.getValidVersion(version) + FORM_DATA_BASE_PATH + updateParam.getAppId() + "/entry/"
                + updateParam.getEntryId() + "/data_update";
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", updateParam.getDataId());
        data.put("data", updateParam.getData());
        data.put("is_start_trigger", updateParam.getIs_start_trigger());
        data.put("transaction_id", updateParam.getTransaction_id());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }


    /**
     * 刪除单条数据接口
     *
     * @param deleteParam - 删除的数据信息
     * @return status
     */
    public Map<String, Object> singleDataRemove(FormDataDeleteParam deleteParam) throws Exception {
        if (StringUtils.isBlank(deleteParam.getAppId()) || StringUtils.isBlank(deleteParam.getDataId()) ||
                StringUtils.isBlank(deleteParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion("v1") + APP_BASE_PATH + deleteParam.getAppId() + "/entry/" + deleteParam.getEntryId() + "/data_delete";
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", deleteParam.getDataId());
        data.put("is_start_trigger", deleteParam.getIs_start_trigger());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 新建多条数据接口
     *
     * @param createParam - 新建的数据信息
     * @return success_count
     */
    public Map<String, Object> batchDataCreate(FormDataBatchCreateParam createParam) throws Exception {
        if (createParam == null || !createParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion("v1") + APP_BASE_PATH + createParam.getAppId() + "/entry/" + createParam.getEntryId() + "/data_batch_create";
        Map<String, Object> data = new HashMap<>();
        data.put("data_list", createParam.getDataList());
        data.put("is_start_workflow", createParam.getIs_start_workflow());
        data.put("transaction_id", createParam.getTransaction_id());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 查询多条数据接口
     *
     * @param queryParam - 查询参数
     * @return 数据信息
     */
    public Map<String, Object> batchDataQuery(FormDataQueryParam queryParam) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion("v1") + APP_BASE_PATH + queryParam.getAppId() + "/entry/"
                + queryParam.getEntryId() + "/data";
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", queryParam.getDataId());
        data.put("fields", queryParam.getFieldList());
        data.put("filter", queryParam.getFilter());
        data.put("limit", queryParam.getLimit());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 删除多条数据接口
     *
     * @param appId - 应用 Id
     * @param entryId - 表单 Id
     * @param dataIdList - 数据 Id 列表
     * @return status 和 success_count
     */
    public Map<String, Object> batchDataRemove(String appId, String entryId, List<String> dataIdList) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId)) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion("v1") + APP_BASE_PATH + appId + "/entry/" + entryId + "/data_batch_delete";
        Map<String, Object> data = new HashMap<>();
        data.put("data_ids", dataIdList);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 修改多条数据接口
     *
     * @param updateParam - 更新数据的信息
     * @return status 和 success_count
     */
    public Map<String, Object> batchDataUpdate(FormDataBatchUpdateParam updateParam) throws Exception {
        if (updateParam == null || !updateParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion("v1") + APP_BASE_PATH + updateParam.getAppId() + "/entry/" + updateParam.getEntryId()
                + "/data_batch_update";
        Map<String, Object> data = new HashMap<>();
        data.put("data_ids", updateParam.getDataIds());
        data.put("transaction_id", updateParam.getTransaction_id());
        data.put("data", updateParam.getData());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

}
