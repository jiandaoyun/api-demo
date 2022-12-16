class HttpConstant:
    HOST = "https://api.jiandaoyun.com/api"

    HOST_V1 = HOST + "/v1"
    HOST_V4 = HOST + "/v4"

    # d应用相关的接口前缀
    APP_BASE_PATH = "/{version}/app/"
    # 表单相关的接口前缀
    FORM_BASE_PATH = "/{version}/app/"

    # API_KEY
    API_KEY = "API_KEY"

    APP_ID = "APP_ID"

    WORK_FLOW_ENTRY_ID = "WORK_FLOW_ENTRY_ID"

    ENTRY_ID = "ENTRY_ID"

    # 企业互联的接口
    CORP_COOP_PATH = "/{version}/corp/guest/{suffix}"

    # 部门相关的接口
    DEPT_PATH = "/{version}/corp/department/{suffix}"

    # 成员相关的接口
    MEMBER_PATH = "/{version}/corp/user/{suffix}"

    # 角色的接口前缀
    ROLE_PATH = "/{version}/corp/role/{suffix}"

    # 角色组相关的前缀
    ROLE_GROUP_PATH = "/{version}/corp/role_group/{suffix}"

    # 应用相关的接口前缀
    APP_PATH = "/{version}/app/{suffix}"

    # 表单查询的path
    FORM_PATH = '/{version}/app/entry/{suffix}'

    # 表单数据查询的path
    FORM_DATA_PATH = '/{version}/app/entry/data/{suffix}'
