from src.constants.http_constant import HttpConstant
from src.model.form.form_data_create_param import FormDataCreateParam
from src.model.form.form_data_update_param import FormDataUpdateParam
from src.model.form.form_data_delete_param import FormDataDeleteParam
from src.model.form.form_data_batch_create_param import FormDataBatchCreateParam
from src.model.form.form_data_query_param import FormDataQueryParam
from src.model.form.form_data_batch_update_param import FormDataBatchUpdateParam
from src.api.jdy.form_data import FormDataApiClient

formDataApiClient = FormDataApiClient(HttpConstant.API_KEY, HttpConstant.HOST)

num_widget = '_widget_1669106585318'
text_widget = '_widget_1669106585317'
address_widget = '_widget_1669106585320'
data_widget = '_widget_1669106585319'

data_id = None
data_ids = None


# 测试 新建单条数据接口
def singleDataCreate():
    form_data_create_param = FormDataCreateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data[num_widget] = {'value': 321}
    # 单行文本
    data[text_widget] = {'value': '单行文本2333'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址'}
    data[address_widget] = {'value': address}
    # 日期
    data[data_widget] = {'value': 1654876800000}
    form_data_create_param.setData(data)
    result = formDataApiClient.singleDataCreate(form_data_create_param)
    print('singleDataCreate result:', result)
    return result


# 测试 查询单条数据接口
def singleDataQuery():
    form_data_query_param = FormDataQueryParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    form_data_query_param.setDataId(data_id)
    result = formDataApiClient.singleDataQuery(form_data_query_param)
    print('singleDataQuery result:', result)


# 测试 修改单条数据接口
def singleDataUpdate():
    form_data_update_param = FormDataUpdateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data[num_widget] = {'value': 234}
    # 单行文本
    data[text_widget] = {'value': '单行文本3344'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址234'}
    data[address_widget] = {'value': address}
    # 日期
    data[data_widget] = {'value': 1654981900000}
    form_data_update_param.setData(data)
    form_data_update_param.setDataId(data_id)
    result = formDataApiClient.singleDataUpdate(form_data_update_param)
    print('singleDataUpdate result:', result)


# 测试 删除单条数据接口
def singleDataRemove():
    form_data_delete_param = FormDataDeleteParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    form_data_delete_param.setDataId(data_id)
    result = formDataApiClient.singleDataRemove(form_data_delete_param)
    print('singleDataRemove result:', result)


# 测试 新建多条数据接口
def batchDataCreate():
    form_data_batch_create_param = FormDataBatchCreateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data[num_widget] = {'value': 321}
    # 单行文本
    data[text_widget] = {'value': '单行文本2333'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址'}
    data[address_widget] = {'value': address}
    # 日期
    data[data_widget] = {'value': 1654876800000}
    data_list = []
    data_list.append(data)
    data_list.append(data)
    form_data_batch_create_param.setDataList(data_list)
    result = formDataApiClient.batchDataCreate(form_data_batch_create_param)
    print('batchDataCreate result:', result)
    return result


# 测试 查询多条数据接口
def batchDataQuery():
    form_data_query_param = FormDataQueryParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    # 从 62a2fc6f5e66850006738f73 这条数据开始 查找10条数据
    form_data_query_param.setDataId(data_ids[0])
    form_data_query_param.setLimit(10)
    # 只查这两个字段
    form_data_query_param.setFields([num_widget, text_widget])
    # 过滤条件
    filter = {}
    # 关系是 and
    filter['rel'] = 'and'
    condList = [{'field': text_widget, 'type': 'text', 'method': 'eq', 'value': ['单行文本1']}]
    filter['cond'] = condList
    form_data_query_param.setFilter(filter)
    result = formDataApiClient.batchDataQuery(form_data_query_param)
    print('batchDataQuery result:', result)


# 测试 删除多条数据接口
def batchDataRemove():
    formDataDeleteParam = FormDataDeleteParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    formDataDeleteParam.setDataIds(data_ids)
    result = formDataApiClient.batchDataRemove(formDataDeleteParam)
    print('batchDataRemove result:', result)


# 测试 更新多条数据接口
def batchDataUpdate():
    form_data_batch_update_param = FormDataBatchUpdateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    form_data_batch_update_param.setDataIds(data_ids)
    # 仅将 _widget_1654848548501 这个字段的值改成2
    data = {num_widget: {'value': 2}}
    form_data_batch_update_param.setData(data)
    result = formDataApiClient.batchDataUpdate(form_data_batch_update_param)
    print('batchDataUpdate result:', result)


if __name__ == '__main__':
    # 单条测试
    data = singleDataCreate()
    data_id = data['data']['_id']
    singleDataQuery()
    singleDataUpdate()
    singleDataRemove()

    # 批量测试
    batchData = batchDataCreate()
    data_ids = batchData['success_ids']
    batchDataUpdate()
    batchDataQuery()
    batchDataRemove()
