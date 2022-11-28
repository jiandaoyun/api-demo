package model.form;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class FormDataBatchRemoveParam {

    private List<String> data_ids;

    private String app_id;

    private String entry_id;

    public FormDataBatchRemoveParam(String app_id, String entry_id, List<String> data_ids) {
        this.data_ids = data_ids;
        this.app_id = app_id;
        this.entry_id = entry_id;
    }

    public List<String> getData_ids() {
        return data_ids;
    }

    public void setData_ids(List<String> data_ids) {
        this.data_ids = data_ids;
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

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id()) && CollectionUtils.isNotEmpty(data_ids);
    }

    @Override
    public String toString() {
        return "FormDataBatchRemove{" +
                "data_ids=" + data_ids +
                ", app_id='" + app_id + '\'' +
                ", entry_id='" + entry_id + '\'' +
                '}';
    }
}
