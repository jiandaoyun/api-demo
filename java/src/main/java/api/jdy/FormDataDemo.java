package api.jdy;

import constants.HttpConstant;
import model.form.*;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.FORM_DATA_BASE_URL;
import static constants.HttpConstant.FORM_DATA_V1_URL;

/**
 * 表单数据相关的请求Demo
 */
public class FormDataDemo {


    /**
     * 新建单条数据接口
     *
     * @param createParam
     * @throws Exception
     */
    public Map<String, Object> singleDataCreate(FormDataCreateParam createParam) throws Exception {
        if (StringUtils.isBlank(createParam.getAppId()) || StringUtils.isBlank(createParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_BASE_URL + createParam.getAppId() + "/entry/" + createParam.getEntryId() + "/data_create";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data", createParam.getData());
        data.put("is_start_workflow", createParam.getIs_start_workflow());
        data.put("is_start_trigger", createParam.getIs_start_trigger());
        data.put("transaction_id", createParam.getTransaction_id());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }


    /**
     * 查询单条数据接口
     *
     * @param appId
     * @param entryId
     * @param dataId
     * @return
     * @throws Exception
     */
    public Map<String, Object> singleDataQuery(String appId, String entryId, String dataId) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId)) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_BASE_URL + appId + "/entry/" + entryId + "/data_retrieve";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", dataId);
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    /**
     * 修改单条数据接口
     *
     * @param updateParam
     * @return
     * @throws Exception
     */
    public Map<String, Object> singleDataUpdate(FormDataUpdateParam updateParam) throws Exception {
        if (StringUtils.isBlank(updateParam.getAppId()) || StringUtils.isBlank(updateParam.getEntryId())
                || StringUtils.isBlank(updateParam.getDataId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_BASE_URL + updateParam.getAppId() + "/entry/" + updateParam.getEntryId() + "/data_update";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", updateParam.getDataId());
        data.put("data", updateParam.getData());
        data.put("is_start_trigger", updateParam.getIs_start_trigger());
        data.put("transaction_id", updateParam.getTransaction_id());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }


    /**
     * 刪除单条数据接口
     *
     * @param deleteParam
     * @return
     * @throws Exception
     */
    public Map<String, Object> singleDataRemove(FormDataDeleteParam deleteParam) throws Exception {
        if (StringUtils.isBlank(deleteParam.getAppId()) || StringUtils.isBlank(deleteParam.getDataId()) ||
                StringUtils.isBlank(deleteParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_V1_URL + deleteParam.getAppId() + "/entry/" + deleteParam.getEntryId() + "/data_delete";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", deleteParam.getDataId());
        data.put("is_start_trigger", deleteParam.getIs_start_trigger());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    /**
     * 新建多条数据接口
     *
     * @param createParam
     * @throws Exception
     */
    public Map<String, Object> batchDataCreate(FormDataBatchCreateParam createParam) throws Exception {
        if (StringUtils.isBlank(createParam.getAppId()) || StringUtils.isBlank(createParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_V1_URL + createParam.getAppId() + "/entry/" + createParam.getEntryId() + "/data_batch_create";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_list", createParam.getDataList());
        data.put("is_start_workflow", createParam.getIs_start_workflow());
        data.put("transaction_id", createParam.getTransaction_id());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    /**
     * 查询多条数据接口
     *
     * @param queryParam
     * @throws Exception
     */
    public Map<String, Object> batchDataQuery(FormDataQueryParam queryParam) throws Exception {
        if (StringUtils.isBlank(queryParam.getAppId()) || StringUtils.isBlank(queryParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_V1_URL + queryParam.getAppId() + "/entry/" + queryParam.getEntryId() + "/data";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_id", queryParam.getDataId());
        data.put("fields", queryParam.getFieldList());
        data.put("filter", queryParam.getFilter());
        data.put("limit", queryParam.getLimit());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    /**
     * 删除多条数据接口
     *
     * @param appId
     * @param entryId
     * @param dataIdList
     * @return
     * @throws Exception
     */
    public Map<String, Object> batchDataRemove(String appId, String entryId, List<String> dataIdList) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId)) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_V1_URL + appId + "/entry/" + entryId + "/data_batch_delete";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_ids", dataIdList);
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    /**
     * 修改多条数据接口
     *
     * @param updateParam
     * @return
     * @throws Exception
     */
    public Map<String, Object> batchDataUpdate(FormDataBatchUpdateParam updateParam) throws Exception {
        if (StringUtils.isBlank(updateParam.getAppId()) || StringUtils.isBlank(updateParam.getEntryId())) {
            throw new RuntimeException("param lack!");
        }
        String url = FORM_DATA_V1_URL + updateParam.getAppId() + "/entry/" + updateParam.getEntryId() + "/data_batch_update";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Map<String, Object> data = new HashMap<>();
        data.put("data_ids", updateParam.getDataIds());
        data.put("transaction_id", updateParam.getTransaction_id());
        data.put("data", updateParam.getData());
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

//
//    /**
//     * 修改多条数据接口
//     */
//    async batchDataUpdate(appId, entryId, dataIds, data, options) {
//        return await this.doRequest({
//                version: 'v1',
//                method: 'POST',
//                path: `/app/${appId}/entry/${entryId}/data_batch_update`,
//                payload: {
//            data_ids: dataIds,
//                    data,
//                    transaction_id: options.transactionId
//        }
//        });
//    }


}
