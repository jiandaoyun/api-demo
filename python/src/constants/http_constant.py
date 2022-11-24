class HttpConstant:
    HOST = "https://api-dev.jiandaoyun.com/api"

    HOST_V1 = HOST + "/v1"
    HOST_V4 = HOST + "/v4"

    # d应用相关的接口前缀
    APP_BASE_PATH = "/{version}/app/"
    # 表单相关的接口前缀
    FORM_BASE_PATH = "/{version}/app/"

    # 把 API_KEY 修改成自己的API_KEY
    API_KEY = "API_KEY"

    APP_ID = "APP_ID"

    WORK_FLOW_ENTRY_ID = "WORK_FLOW_ENTRY_ID"

    ENTRY_ID = "ENTRY_ID"

    # 企业互联的接口
    CORP_COOP_PATH = "/{version}/corp_coop/{suffix}"

    # 部门相关的接口前缀
    DEPT_BASE_PATH = "/{version}/department/{dept_no}/{suffix}"
    # 部门相关的接口
    DEPT_PATH = "/{version}/department/{suffix}"

    # 成员相关的接口
    MEMBER_PATH = "/{version}/user/{suffix}"
    # 成员相关的接口前缀
    MEMBER_BASE_PATH = "/{version}/user/{user_name}/{suffix}"

    # 角色的接口前缀
    ROLE_PATH = "/{version}/role/{suffix}"

    # 角色组相关的前缀
    ROLE_GROUP_PATH = "/{version}/role_group/{suffix}"

    # 应用相关的接口前缀
    APP_PATH = "/{version}/app/{suffix}"

    # 上传文件的path
    FILE_UPLOAD_PATH = APP_BASE_PATH + '{app_id}/entry/{entry_id}/file/get_upload_token'

    # 表单查询的path
    ENTRY_LIST_PATH = APP_BASE_PATH + '{app_id}/entry_retrieve'
    # 表单字段查询的path
    FORM_WIDGETS_PATH = FORM_BASE_PATH + '{app_id}/entry/{entry_id}/widgets'

    # 表单流程数据的审批意见的path
    APPROVAL_COMMENTS_PATH = APP_BASE_PATH + '{app_id}/entry/{entry_id}/data/{data_id}/approval_comments'

    # V4版本的表单数据前缀
    DATA_PATH = "/{version}/app/{app_id}/entry/{entry_id}/{suffix}"

    # V1版本的表单数据前缀
    DATA_V1_PATH = "/v1/app/{app_id}/entry/{entry_id}/{suffix}"
