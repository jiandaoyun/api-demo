package model.form;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class FormDataQueryParam {
    /**
     * 应用id
     */
    private String app_id;

    /**
     * 表单id
     */
    private String entry_id;

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
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id());
    }

    public boolean isSingleQueryValid() {
        return this.isValid() && StringUtils.isNotBlank(this.getDataId());
    }

    public FormDataQueryParam() {
    }

    public FormDataQueryParam(String app_id, String entry_id) {
        this.app_id = app_id;
        this.entry_id = entry_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
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
                "app_id='" + app_id + '\'' +
                ", entry_id='" + entry_id + '\'' +
                ", dataId='" + dataId + '\'' +
                ", limit=" + limit +
                ", fieldList=" + fieldList +
                ", filter=" + filter +
                '}';
    }
}
