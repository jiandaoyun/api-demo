package constants;

/**
 * http 相关的常量
 */
public class HttpConstant {
//    public static final String HOST = "https://api.jiandaoyun.com/api";

    public static final String HOST = "http://localhost:3000/api";

    public static final String HOST_V2 = HOST + "/v2";

    public static final String HOST_V1 = HOST + "/v1";

    public static final String HOST_V4 = HOST + "/v4";

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


    /**
     * 企业互联的接口前缀
     */
    public static final String CORP_COOP_BASE_URL = HOST_V4 + "/corp_coop/";

    /**
     * 角色相关的接口前缀
     */
    public static final String ROLE_BASE_URL = HOST_V2 + "/role/";

    /**
     * 角色相关的接口前缀
     */
    public static final String ROLE_GROUP_BASE_URL = HOST_V2 + "/role_group/";

    /**
     * 表单相关的接口前缀
     */
    public static final String FORM_BASE_URL = HOST_V2 + "/app/";

    /**
     * 表单数据相关的接口前缀
     */
    public static final String FORM_DATA_BASE_URL = HOST_V4 + "/app/";

    public static final String API_KEY = "pQZ24l3mrlfum2H9ghrefQvGvvEGtIM7";//  pQZ24l3mrlfum1H9ghrefQvGvvEGtIM8

    public static final String APP_ID = "62a2fc216575a5000628c41f";

    public static final String WORK_FLOW_ENTRY_ID = "62a696f514b27e0006836b60";

    public static final String ENTRY_ID = "62a2fc246575a5000628c444";

}
