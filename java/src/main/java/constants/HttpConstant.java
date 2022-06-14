package constants;

/**
 * http 相关的常量
 */
public class HttpConstant {
    public static final String HOST = "https://api.jiandaoyun.com/api";

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
     * 角色组相关的接口前缀
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

    public static final String API_KEY = "API_KEY";

    public static final String APP_ID = "APP_ID";

    public static final String WORK_FLOW_ENTRY_ID = "WORK_FLOW_ENTRY_ID";

    public static final String ENTRY_ID = "ENTRY_ID";

}
