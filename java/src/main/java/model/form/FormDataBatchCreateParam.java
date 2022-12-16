package model.form;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class FormDataBatchCreateParam {
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
    private List<Map<String, Object>> data_list;

    private Boolean is_start_workflow;


    private String transaction_id;

    public FormDataBatchCreateParam() {
    }

    public FormDataBatchCreateParam(String app_id, String entry_id, List<Map<String, Object>> data_list) {
        this.app_id = app_id;
        this.entry_id = entry_id;
        this.data_list = data_list;
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

    public List<Map<String, Object>> getData_list() {
        return data_list;
    }

    public void setData_list(List<Map<String, Object>> data_list) {
        this.data_list = data_list;
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



    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id());
    }

    @Override
    public String toString() {
        return "FormDataBatchCreateParam{" +
                "appId='" + app_id + '\'' +
                ", entry_id='" + entry_id + '\'' +
                ", data_list=" + data_list +
                ", is_start_workflow=" + is_start_workflow +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
