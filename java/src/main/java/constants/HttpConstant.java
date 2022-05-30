package constants;

/**
 * http 相关的常量
 */
public class HttpConstant {
    public static final String HOST = "https://api.jiandaoyun.com/api";

    public static final String HOST_V2 = HOST + "/v2";

    public static final String HOST_V1 = HOST + "/v1";

    /**
     * 部门相关的接口前缀
     */
    public static final String DEPT_BASE_URL = HOST_V2 + "/department/";

    /**
     * 成员相关的接口前缀
     */
    public static final String MEMBER_BASE_URL = HOST_V2 + "/user/";

    /**
     * 应用相关的接口前缀
     */
    public static final String APP_BASE_URL = HOST_V1 + "/app/";


    public static final String API_KEY = "TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp";

}
