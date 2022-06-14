class HttpConstant:
    HOST = "https://api.jiandaoyun.com/api"

    HOST_V2 = HOST + "/v2"
    HOST_V1 = HOST + "/v1"
    HOST_V4 = HOST + "/v4"

    #     部门相关的接口前缀
    DEPT_BASE_URL = HOST_V2 + "/department/"
    #     成员相关的接口前缀
    MEMBER_BASE_URL = HOST_V2 + "/user/"
    #     应用相关的接口前缀
    APP_BASE_URL = HOST_V1 + "/app/"
    # 企业互联的接口前缀
    CORP_COOP_BASE_URL = HOST_V4 + "/corp_coop/"
    # 角色的接口前缀
    ROLE_BASE_URL = HOST_V2 + "/role/"
    # 角色组相关的接口前缀
    ROLE_GROUP_BASE_URL = HOST_V2 + "/role_group/"
    # 表单相关的接口前缀
    FORM_BASE_URL = HOST_V2 + "/app/"
    # 表单数据相关的接口前缀
    FORM_DATA_BASE_URL = HOST_V4 + "/app/"

    #   把 API_KEY 修改成自己的API_KEY
    API_KEY = "API_KEY"

    APP_ID = "APP_ID"

    WORK_FLOW_ENTRY_ID = "WORK_FLOW_ENTRY_ID"

    ENTRY_ID = "ENTRY_ID"
