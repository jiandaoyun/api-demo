package model.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import util.LimitUtil;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiClient {

    /**
     * apiKey
     */
    private String apiKey;

    /**
     * 地址
     */
    private String host;

    /**
     * 默认版本
     */
    private String defaultVersion;

    /**
     * 合法版本
     */
    private List<String> validVersionList;

    public ApiClient(String apiKey, String host) {
        this.apiKey = apiKey;
        this.host = host;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDefaultVersion() {
        return defaultVersion;
    }

    public void setDefaultVersion(String defaultVersion) {
        this.defaultVersion = defaultVersion;
    }

    public List<String> getValidVersionList() {
        return validVersionList;
    }

    public void setValidVersionList(List<String> validVersionList) {
        this.validVersionList = validVersionList;
    }


    /**
     * 生成 path
     *
     * @param version - 版本号
     * @param path    - 路径
     * @return 接口的路径
     */
    public abstract String generatePath(String version, String path);

    /**
     * 获得合法的版本号
     *
     * @param version - 版本号
     * @return 合法的版本号
     */
    public String getValidVersion(String version) {
        if (this.getValidVersionList() != null && this.getValidVersionList().contains(version)) {
            return version;
        }
        return this.getDefaultVersion();
    }

    /**
     * 发送POST请求
     *
     * @param param - 请求参数
     * @return 接口返回参数
     */
    public Map<String, Object> sendPostRequest(HttpRequestParam param) throws Exception {
        if (param == null || StringUtils.isBlank(param.getPath())) {
            throw new RuntimeException("缺失参数！");
        }
        HttpClient client = getSSLHttpClient();
        Header[] headers = getHttpHeaders(this.getApiKey());
        String url = this.host + param.getPath();
        HttpRequestBase request = new HttpPost(url);

        // 请求参数
        if (param.getData() != null) {
            ObjectMapper queryMap = new ObjectMapper();
            HttpEntity entity = new StringEntity(queryMap.writeValueAsString(param.getData()), Charsets.UTF_8);
            ((HttpPost) request).setEntity(entity);
        }
        // 设置请求头
        request.setHeaders(headers);
        // 限流阻塞
        LimitUtil.tryBeforeRun();
        // 发送请求并获取返回结果
        HttpResponse response = client.execute(request);
        // 返回状态码
        int statusCode = response.getStatusLine().getStatusCode();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<>();
        // 有部分接口直接返回 没有数据
        // fix：不能用content-length大于0判断，response header为gzip编码方式的情况下为-1
        if (!(response.getEntity().getContent() instanceof EmptyInputStream)) {
            result = (Map<String, Object>) mapper.readValue(response.getEntity().getContent(), Object.class);
        }
        if (statusCode >= 400) {
            throw new RuntimeException("请求错误，statusCode:" + statusCode + ",Error Code: " + result.get("code") + ", Error Msg: " + result.get("msg"));
        } else {
            // 处理返回结果
            return result;
        }
    }

    private static HttpClient getSSLHttpClient() throws Exception {
        //信任所有
        SSLContext sslContext =
                new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * 获取请求头信息
     *
     * @return 请求头信息
     */
    private Header[] getHttpHeaders(String apiKey) {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new BasicHeader("Authorization", "Bearer " + apiKey));
        headerList.add(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
        return headerList.toArray(new Header[headerList.size()]);
    }

    public Map<String, Object> httpPostFile(String url, String token, File file) throws Exception {
        HttpClient client = getSSLHttpClient();
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        httpPost.addHeader("token", token);
        builder.addBinaryBody("file", file, ContentType.MULTIPART_FORM_DATA, file.getName());
        // 传递 token
        builder.addTextBody("token", token);
        StringBody tokenBody = new StringBody(token, ContentType.MULTIPART_FORM_DATA);
        builder.addPart("token", tokenBody);
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        // 限流阻塞
        LimitUtil.tryBeforeRun();
        // 发送请求并获取返回结果
        HttpResponse response = client.execute(httpPost);
        // 返回状态码
        int statusCode = response.getStatusLine().getStatusCode();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<>();
        // 有部分接口直接返回 没有数据
        // fix：不能用content-length大于0判断，response header为gzip编码方式的情况下为-1
        if (!(response.getEntity().getContent() instanceof EmptyInputStream)) {
            result = (Map<String, Object>) mapper.readValue(response.getEntity().getContent(), Object.class);
        }
        if (statusCode >= 400) {
            throw new RuntimeException("请求错误，statusCode:" + statusCode + ",Error Code: " + result.get("code") + ", Error Msg: " + result.get("msg"));
        } else {
            // 处理返回结果
            return result;
        }
    }
}
