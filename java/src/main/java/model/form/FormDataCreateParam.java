package model.form;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class FormDataCreateParam {
    /**
     * 应用id
     */
    private String app_id;

    /**
     * 表单id
     */
    private String entry_id;

    /**
     * 数据
     */
    private Map<String, Object> data;

    private Boolean is_start_workflow;

    private Boolean is_start_trigger;

    private String transaction_id;

    public FormDataCreateParam() {
    }

    public FormDataCreateParam(String app_id, String entry_id, Map<String, Object> data) {
        this.app_id = app_id;
        this.entry_id = entry_id;
        this.data = data;
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Boolean getIs_start_workflow() {
        return is_start_workflow;
    }

    public void setIs_start_workflow(Boolean is_start_workflow) {
        this.is_start_workflow = is_start_workflow;
    }

    public Boolean getIs_start_trigger() {
        return is_start_trigger;
    }

    public void setIs_start_trigger(Boolean is_start_trigger) {
        this.is_start_trigger = is_start_trigger;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id());
    }

    @Override
    public String toString() {
        return "FormDataCreateParam{" +
                "app_id='" + app_id + '\'' +
                ", entry_id='" + entry_id + '\'' +
                ", data=" + data +
                ", is_start_workflow=" + is_start_workflow +
                ", is_start_trigger=" + is_start_trigger +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
