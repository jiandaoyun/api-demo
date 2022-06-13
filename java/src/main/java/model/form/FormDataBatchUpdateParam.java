package model.form;

import java.util.List;
import java.util.Map;

public class FormDataBatchUpdateParam {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 表单id
     */
    private String entryId;

    private List<String> dataIds;

    /**
     * 数据
     */
    private Map<String, Object> data;


    private String transaction_id;

    public FormDataBatchUpdateParam() {
    }

    public FormDataBatchUpdateParam(String appId, String entryId) {
        this.appId = appId;
        this.entryId = entryId;
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


    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public List<String> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<String> dataIds) {
        this.dataIds = dataIds;
    }

    @Override
    public String toString() {
        return "FormDataBatchUpdateParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataIds=" + dataIds +
                ", data=" + data +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
