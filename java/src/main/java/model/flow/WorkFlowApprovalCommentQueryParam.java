package model.flow;

import model.base.PageBaseParam;
import org.apache.commons.lang3.StringUtils;

public class WorkFlowApprovalCommentQueryParam extends PageBaseParam {
    private String appId;

    private String entryId;

    private String dataId;

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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public boolean isValid() {
        return super.isValid() && StringUtils.isNotBlank(this.getAppId()) && StringUtils.isNotBlank(this.getEntryId())
                && StringUtils.isNotBlank(this.getDataId());
    }

    @Override
    public String toString() {
        return "WorkFlowApprovalCommentQueryParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", skip=" + super.getSkip() +
                ", limit=" + super.getLimit() +
                '}';
    }
}
