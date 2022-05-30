package model.http;

import java.util.Map;

public class HttpRequestParam {

    private String apiKey;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求参数
     */
    private Map<String, Object> data;

    public HttpRequestParam() {
    }


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpRequestParam{" +
                ", apiKey='" + apiKey + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }
}
