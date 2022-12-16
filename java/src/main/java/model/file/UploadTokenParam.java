package model.file;

import org.apache.commons.lang3.StringUtils;

public class UploadTokenParam {
    private String appId;
    private String entryId;
    private String transactionId;

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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getAppId()) && StringUtils.isNotBlank(this.getEntryId())
                && StringUtils.isNotBlank(this.getTransactionId());
    }


    @Override
    public String toString() {
        return "UploadTokenParam{" +
                "appId='" + appId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
