class HttpConstant:
    # HOST = "https://api-dev.jiandaoyun.com/api"
    HOST = "http://localhost:3000/api"

    HOST_V2 = HOST + "/v2"
    HOST_V1 = HOST + "/v1"
    HOST_V4 = HOST + "/v4"

    #     部门相关的接口前缀
    DEPT_BASE_URL = "/{version}/department/"
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
    API_KEY = "pVCkWk96tzghiDttdjXxcj3fTZpdQ5AV"

    APP_ID = "APP_ID"

    WORK_FLOW_ENTRY_ID = "WORK_FLOW_ENTRY_ID"

    ENTRY_ID = "ENTRY_ID"

    # 企业互联的接口
    # CORP_COOP_URL = HOST_V4 + "/corp_coop/{suffix}"
    CORP_COOP_URL = "/{version}/corp_coop/{suffix}"

    # 部门相关的接口
    DEPT_URL = "/{version}/department/{suffix}"
    # 成员相关的接
    MEMBER_URL = HOST_V2 + "/user/{suffix}"
    # 角色的接口前缀
    ROLE_URL = HOST_V2 + "/role/{suffix}"
    # 角色组相关的前缀
    ROLE_GROUP_URL = HOST_V2 + "/role_group/{suffix}"
    # 应用相关的接口前缀
    APP_URL = HOST_V1 + "/app/{suffix}"

    # 上传文件的url
    FILE_UPLOAD_URL = APP_BASE_URL + '{app_id}/entry/{entry_id}/file/get_upload_token'
    # 部门列表的url
    DEPT_LIST_URL = DEPT_BASE_URL + '{deptNo}/department_list'
    # 更新部门的url
    UPDATE_DEPT_URL = DEPT_BASE_URL + '{deptNo}/update'
    # 删除部门的url
    DELETE_DEPT_URL = DEPT_BASE_URL + '{deptNo}/delete'

    # 部门成员的url
    DEPT_MEMBER_LIST_URL = DEPT_BASE_URL + '{deptNo}/member_list'
    # 获取成员信息的url
    USER_INFO_URL = MEMBER_BASE_URL + '{userName}/user_retrieve'
    # 更新成员信息的url
    USER_UPDATE_URL = MEMBER_BASE_URL + '{userName}/update'
    # 更新成员信息的url
    USER_DELETE_URL = MEMBER_BASE_URL + '{userName}/delete'

    # 表单查询的url
    ENTRY_LIST_URL = APP_BASE_URL + '{appId}/entry_retrieve'
    # 表单字段查询的url
    FORM_WIDGETS_URL = FORM_BASE_URL + '{appId}/entry/{entryId}/widgets'

    # 表单流程数据的审批意见的url
    APPROVAL_COMMENTS_URL = APP_BASE_URL + '{appId}/entry/{entryId}/data/{dataId}/approval_comments'

    # V4版本的表单数据前缀
    DATA_V4_URL = HOST_V4 + "/app/{appId}/entry/{entryId}/"
    SINGLE_DATA_CREATE_URL = DATA_V4_URL + "data_create"
    # 查询单条数据接口的url
    SINGLE_DATA_QUERY_URL = DATA_V4_URL + "data_retrieve"
    # 查询单条数据接口的url
    SINGLE_DATA_UPDATE_URL = DATA_V4_URL + "data_update"

    # V1版本的表单数据前缀
    DATA_V1_URL = HOST_V1 + "/app/{appId}/entry/{entryId}/"
    # 删除单条数据接口的url
    SINGLE_DATA_REMOVE_URL = DATA_V1_URL + "data_delete"
    # 新建多条数据接口的url
    BATCH_DATA_CREATE_URL = DATA_V1_URL + "data_batch_create"
    # 查询多条数据接口的url
    BATCH_DATA_QUERY_URL = DATA_V1_URL + "data"
    # 批量删除数据接口的url
    BATCH_DATA_DELETE_URL = DATA_V1_URL + "data_batch_delete"
    # 批量删除数据接口的url
    BATCH_DATA_UPDATE_URL = DATA_V1_URL + "data_batch_update"
