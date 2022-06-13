package model.flow;

public class WorkFlowApprovalCommentQueryParam {
    private String appId;

    private String entryId;

    private String dataId;

    private Integer skip;

    private Integer limit;

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

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "WorkFlowApprovalCommentQueryParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}
