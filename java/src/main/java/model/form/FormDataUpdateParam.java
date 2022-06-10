package model.form;

import java.util.Map;

public class FormDataUpdateParam {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 表单id
     */
    private String entryId;

    private String dataId;

    /**
     * 数据
     */
    private Map<String, Object> data;


    private Boolean is_start_trigger;

    private String transaction_id;

    public FormDataUpdateParam() {
    }

    public FormDataUpdateParam(String appId, String entryId, Map<String, Object> data) {
        this.appId = appId;
        this.entryId = entryId;
        this.data = data;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "FormDataUpdateParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", data=" + data +
                ", is_start_trigger=" + is_start_trigger +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
