class HttpConstant:
    # HOST = "https://api-dev.jiandaoyun.com/api"
    HOST = "http://localhost:3000/api"

    HOST_V1 = HOST + "/v1"
    HOST_V4 = HOST + "/v4"

    # d应用相关的接口前缀
    APP_BASE_PATH = "/{version}/app/"
    # 表单相关的接口前缀
    FORM_BASE_PATH = "/{version}/app/"

    # 把 API_KEY 修改成自己的API_KEY  集成模式 6Q1X2kbk4quufIaFnNu5EdqxgLYOSyxT。公共模式：pVCkWk96tzghiDttdjXxcj3fTZpdQ5AV
    API_KEY = "pVCkWk96tzghiDttdjXxcj3fTZpdQ5AV"

    APP_ID = "63567f0eac9f4e0007c92645"

    WORK_FLOW_ENTRY_ID = "637c83b646be44000747e3d4"

    ENTRY_ID = "637c8b9830ebbc0007bc496f"

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
