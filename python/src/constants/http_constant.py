class HttpConstant:
    HOST = "https://api.jiandaoyun.com/api"
    HOST = "http://localhost:3001/api"

    HOST_V2 = HOST + "/v2"
    HOST_V1 = HOST + "/v1"

    #     部门相关的接口前缀
    DEPT_BASE_URL = HOST_V2 + "/department/"
    #     成员相关的接口前缀
    MEMBER_BASE_URL = HOST_V2 + "/user/"
    #     应用相关的接口前缀
    APP_BASE_URL = HOST_V1 + "/app/"

    #   把 API_KEY 修改成自己的API_KEY
    API_KEY = "pQZ24l3mrlfum1H9ghrefQvGvvEGtIM8"
