package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.http.HttpRequestParam;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    /**
     * 发送POST请求
     *
     * @param param - 请求参数
     * @throws Exception
     */
    public static Map<String, Object> sendPostRequest(HttpRequestParam param) throws Exception {
        if (param == null || StringUtils.isBlank(param.getUrl()) || StringUtils.isBlank(param.getApiKey())) {
            throw new RuntimeException("缺失参数！");
        }
        HttpClient client = getSSLHttpClient();
        Header[] headers = getHttpHeaders(param.getApiKey());
        HttpRequestBase request = new HttpPost(param.getUrl());

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
        if (response.getEntity().getContentLength() > 0) {
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
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            //信任所有
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * 获取请求头信息
     *
     * @return
     */
    private static Header[] getHttpHeaders(String apiKey) {
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(new BasicHeader("Authorization", "Bearer " + apiKey));
        headerList.add(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
        return headerList.toArray(new Header[headerList.size()]);
    }

    public static void httpPostFile(String url, File file, String token) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
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
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("结果：\n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        String result = "";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        try {
//            HttpPost httpPost = new HttpPost(url);
//            //HttpMultipartMode.RFC6532参数的设定是为避免文件名为中文时乱码
//            MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
////            httpPost.addHeader("header1", "zip");//头部放文件上传的head可自定义
//            httpPost.setHeader("token", token);
//
//            builder.addBinaryBody("file", file, ContentType.MULTIPART_FORM_DATA, file.getName());
//            builder.addTextBody("token", token);
//            HttpEntity entity = builder.build();
//            httpPost.setEntity(entity);
//            response = httpClient.execute(httpPost);// 执行提交
//            HttpEntity responseEntity = response.getEntity();//接收调用外部接口返回的内容
//            // 通过EntityUtils中的toString方法将结果转换为字符串
//            result = EntityUtils.toString(responseEntity);
//            System.out.println("result =" + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {//处理结束后关闭httpclient的链接
//            try {
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
