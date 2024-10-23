package model.http;

import java.util.Map;

public class HttpRequestParam {

    /**
     * 请求路径
     */
    private String path;

    /**
     * 请求参数
     */
    private Map<String, Object> data;

    public HttpRequestParam() {
    }

    public HttpRequestParam(String path, Map<String, Object> data) {
        this.path = path;
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
                "path='" + path + '\'' +
                ", data=" + data +
                '}';
    }
}
