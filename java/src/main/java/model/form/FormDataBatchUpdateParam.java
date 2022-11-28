package model.form;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class FormDataBatchUpdateParam {
    /**
     * 应用id
     */
    private String app_id;

    /**
     * 表单id
     */
    private String entry_id;

    private List<String> data_ids;

    /**
     * 数据
     */
    private Map<String, Object> data_list;


    private String transaction_id;

    public FormDataBatchUpdateParam() {
    }

    public FormDataBatchUpdateParam(String app_id, String entry_id) {
        this.app_id = app_id;
        this.entry_id = entry_id;
    }


    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
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

    public List<String> getData_ids() {
        return data_ids;
    }

    public void setData_ids(List<String> data_ids) {
        this.data_ids = data_ids;
    }

    public Map<String, Object> getData_list() {
        return data_list;
    }

    public void setData_list(Map<String, Object> data_list) {
        this.data_list = data_list;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && StringUtils.isNotBlank(this.getEntry_id())
                && CollectionUtils.isNotEmpty(this.getData_ids());

    }

    @Override
    public String toString() {
        return "FormDataBatchUpdateParam{" +
                "app_id='" + app_id + '\'' +
                ", entry_id='" + entry_id + '\'' +
                ", data_ids=" + data_ids +
                ", data_list=" + data_list +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
