package constants;

/**
 * http 相关的常量
 */
public class HttpConstant {
//    public static final String HOST = "https://api.jiandaoyun.com/api"; // TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp

    public static final String HOST = "http://localhost:3000/api"; //pQZ24l3mrlfum1H9ghrefQvGvvEGtIM8


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


    public static final String API_KEY = "pQZ24l3mrlfum1H9ghrefQvGvvEGtIM8";

}
