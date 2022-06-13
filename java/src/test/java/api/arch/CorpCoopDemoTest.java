package api.arch;

import java.util.Map;

public class CorpCoopDemoTest {
    public static void main(String[] args) throws Exception {
        CorpCoopDemo corpCoopDemo = new CorpCoopDemo();
        // 列出我连接的企业
        corpCoopDepartList(corpCoopDemo);
        // 列出我连接的企业对接人
        corpCoopMemberList(corpCoopDemo);
        // 列出我连接的企业对接人详细信息
        corpCoopUserInfo(corpCoopDemo);
    }

    private static void corpCoopDepartList(CorpCoopDemo corpCoopDemo) throws Exception {
        Map<String, Object> result = corpCoopDemo.corpCoopDepartList(null);
        System.out.println("deptList result\n" + result);
    }

    private static void corpCoopMemberList(CorpCoopDemo corpCoopDemo) throws Exception {
        Map<String, Object> result = corpCoopDemo.corpCoopMemberList(null);
        System.out.println("corpCoopMemberList result\n" + result);
    }

    private static void corpCoopUserInfo(CorpCoopDemo corpCoopDemo) throws Exception {
        Map<String, Object> result = corpCoopDemo.corpCoopUserInfo("R-61150d0d497d9f0006448073-jdy-pr55od7jrsl7");
        System.out.println("corpCoopUserInfo result\n" + result);
    }
}
