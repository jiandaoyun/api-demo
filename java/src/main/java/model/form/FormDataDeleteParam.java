package model.form;

public class FormDataDeleteParam {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 表单id
     */
    private String entryId;

    private String dataId;

    private Boolean is_start_trigger;


    public FormDataDeleteParam() {
    }

    public FormDataDeleteParam(String appId, String entryId, String dataId) {
        this.appId = appId;
        this.entryId = entryId;
        this.dataId = dataId;
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

    public Boolean getIs_start_trigger() {
        return is_start_trigger;
    }

    public void setIs_start_trigger(Boolean is_start_trigger) {
        this.is_start_trigger = is_start_trigger;
    }


    @Override
    public String toString() {
        return "FormDataUpdateParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", is_start_trigger=" + is_start_trigger +
                '}';
    }
}
