package model.form;

import model.base.PageBaseParam;
import org.apache.commons.lang3.StringUtils;

public class FormQueryParam extends PageBaseParam {

    private String app_id;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getApp_id()) && super.isValid();
    }

    @Override
    public String toString() {
        return "FormQueryParam{" +
                "skip=" + super.getSkip() +
                ", limit=" + super.getLimit() +
                ", app_id=" + app_id +
                '}';
    }
}
