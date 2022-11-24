package model.form;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class FormDataCreateParam {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 表单id
     */
    private String entryId;

    /**
     * 数据
     */
    private Map<String, Object> data;

    private Boolean is_start_workflow;

    private Boolean is_start_trigger;

    private String transaction_id;

    public FormDataCreateParam() {
    }

    public FormDataCreateParam(String appId, String entryId, Map<String, Object> data) {
        this.appId = appId;
        this.entryId = entryId;
        this.data = data;
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
        return StringUtils.isNotBlank(this.getAppId()) && StringUtils.isNotBlank(this.getEntryId());
    }

    @Override
    public String toString() {
        return "FormDataCreateParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", data=" + data +
                ", is_start_workflow=" + is_start_workflow +
                ", is_start_trigger=" + is_start_trigger +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
