package model.form;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class FormDataQueryParam {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 表单id
     */
    private String entryId;

    /**
     * 数据ID
     */
    private String dataId;

    /**
     * 从 数据ID 开始返回 limit 条数据
     */
    private Integer limit;

    /**
     * 查询的字段
     */
    private List<String> fieldList;

    /**
     * 过滤条件
     */
    private Map<String, Object> filter;

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getAppId()) && StringUtils.isNotBlank(this.getEntryId());
    }

    public boolean isSingleQueryValid() {
        return this.isValid() && StringUtils.isNotBlank(this.getDataId());
    }

    public FormDataQueryParam() {
    }

    public FormDataQueryParam(String appId, String entryId, String dataId) {
        this.appId = appId;
        this.entryId = entryId;
        this.dataId = dataId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "FormDataQueryParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", limit=" + limit +
                ", fieldList=" + fieldList +
                ", filter=" + filter +
                '}';
    }
}
