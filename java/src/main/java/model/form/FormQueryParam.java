package model.form;

import model.base.PageBaseParam;
import org.apache.commons.lang3.StringUtils;

public class FormQueryParam extends PageBaseParam {

    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getAppId()) && super.isValid();
    }

    @Override
    public String toString() {
        return "FormQueryParam{" +
                "skip=" + super.getSkip() +
                ", limit=" + super.getLimit() +
                ", appId=" + appId +
                '}';
    }
}
