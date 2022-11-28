package model.form;

import org.apache.commons.lang3.StringUtils;

public class FormDataDeleteParam {
    /**
     * 应用id
     */
    private String app_id;

    /**
     * 表单id
     */
    private String entry_id;

    private String data_id;

    private Boolean is_start_trigger;


    public FormDataDeleteParam() {
    }

    public FormDataDeleteParam(String app_id, String entry_id, String data_id) {
        this.app_id = app_id;
        this.entry_id = entry_id;
        this.data_id = data_id;
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

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public Boolean getIs_start_trigger() {
        return is_start_trigger;
    }

    public void setIs_start_trigger(Boolean is_start_trigger) {
        this.is_start_trigger = is_start_trigger;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id())
                && StringUtils.isNotBlank(this.getData_id());
    }

    @Override
    public String toString() {
        return "FormDataUpdateParam{" +
                "appId='" + app_id + '\'' +
                ", entryId='" + entry_id + '\'' +
                ", dataId='" + data_id + '\'' +
                ", is_start_trigger=" + is_start_trigger +
                '}';
    }
}
