package model.form;

import java.util.List;
import java.util.Map;

public class FormDataBatchCreateParam {
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
    private List<Map<String, Object>> dataList;

    private Boolean is_start_workflow;


    private String transaction_id;

    public FormDataBatchCreateParam() {
    }

    public FormDataBatchCreateParam(String appId, String entryId, List<Map<String, Object>> dataList) {
        this.appId = appId;
        this.entryId = entryId;
        this.dataList = dataList;
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

    public Boolean getIs_start_workflow() {
        return is_start_workflow;
    }

    public void setIs_start_workflow(Boolean is_start_workflow) {
        this.is_start_workflow = is_start_workflow;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public List<Map<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "FormDataBatchCreateParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataList=" + dataList +
                ", is_start_workflow=" + is_start_workflow +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
