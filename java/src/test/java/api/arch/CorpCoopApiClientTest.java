package api.arch;

import constants.HttpConstant;

import java.util.Map;

public class CorpCoopApiClientTest {

    private static CorpCoopApiClient corpCoopApiClient = new CorpCoopApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 列出我连接的企业
        corpCoopDepartList();
        // 列出我连接的企业对接人
        corpCoopMemberList();
        // 列出我连接的企业对接人详细信息
        corpCoopUserInfo();
    }

    private static void corpCoopDepartList() throws Exception {
        Map<String, Object> result = corpCoopApiClient.corpCoopDepartList(null, null);
        System.out.println("deptList result\n" + result);
    }

    private static void corpCoopMemberList() throws Exception {
        Map<String, Object> result = corpCoopApiClient.corpCoopMemberList(null, null);
        System.out.println("corpCoopMemberList result\n" + result);
    }

    private static void corpCoopUserInfo() throws Exception {
        String userName = "R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg";
        Map<String, Object> result = corpCoopApiClient.corpCoopUserInfo(userName, null);
        System.out.println("corpCoopUserInfo result\n" + result);
    }
}
