package api.jdy;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_URL;

public class FileDemo {

    /**
     * 获取文件上传凭证和上传地址接口
     *
     * @param skip
     * @param limit
     * @throws Exception
     */
//    public Map<String, Object> uploadToken(Integer skip, Integer limit) throws Exception {
//        if (skip == null || limit == null) {
//            throw new RuntimeException("param lack!");
//        }
//        String url = APP_BASE_URL + "retrieve_all";
//        HttpRequestParam param = new HttpRequestParam();
//        param.setApiKey(HttpConstant.API_KEY);
//        param.setUrl(url);
//        // 请求参数
//        Map<String, Object> data = new HashMap<>();
//        data.put("skip", skip);
//        data.put("limit", limit);
//        param.setData(data);
//        Map<String, Object> result = HttpUtil.sendPostRequest(param);
//        System.out.println("appList result:\n" + result.toString());
//        return result;
//    }



//
//    /**
//     * 获取文件上传凭证和上传地址接口
//     */
//    async uploadToken(appId, entryId, transactionId) {
//        return await this.doRequest({
//                method: 'POST',
//                path: `/app/${appId}/entry/${entryId}/file/get_upload_token`,
//                payload: {
//            transaction_id: transactionId
//        }
//        });
//    }
//
//    /**
//     * 文件上传接口
//     */
//    async uploadFile(url, token, file) {
//        let formData = new FormData();
//        formData.append('token', token);
//        formData.append('file', file);
//        const axiosRequestConfig = {
//                method: 'POST',
//                url,
//                data: formData
//        };
//        const response = await axios(axiosRequestConfig);
//        return response.data;
//    }
}
