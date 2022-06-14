import src.api.jdy.form_data_demo as form_data_demo
from src.constants.http_constant import HttpConstant
from src.model.form.form_data_create_param import FormDataCreateParam
from src.model.form.form_data_update_param import FormDataUpdateParam
from src.model.form.form_data_delete_param import FormDataDeleteParam
from src.model.form.form_data_batch_create_param import FormDataBatchCreateParam
from src.model.form.form_data_query_param import FormDataQueryParam
from src.model.form.form_data_batch_update_param import FormDataBatchUpdateParam


# 测试 新建单条数据接口
def singleDataCreate():
    form_data_create_param = FormDataCreateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data['_widget_1654848548501'] = {'value': 321}
    # 单行文本
    data['_widget_1654848548482'] = {'value': '单行文本2333'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址'}
    data['_widget_1654848578745'] = {'value': address}
    # 日期
    data['_widget_1654848591194'] = {'value': 1654876800000}
    form_data_create_param.setData(data)
    result = form_data_demo.singleDataCreate(form_data_create_param)
    print('singleDataCreate result:', result)


# 测试 查询单条数据接口
def singleDataQuery():
    result = form_data_demo.singleDataQuery(HttpConstant.APP_ID, HttpConstant.ENTRY_ID, '62a84cefd66b59a440060227')
    print('singleDataQuery result:', result)


# 测试 修改单条数据接口
def singleDataUpdate():
    form_data_update_param = FormDataUpdateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data['_widget_1654848548501'] = {'value': 234}
    # 单行文本
    data['_widget_1654848548482'] = {'value': '单行文本3344'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址234'}
    data['_widget_1654848578745'] = {'value': address}
    # 日期
    data['_widget_1654848591194'] = {'value': 1654880900000}
    form_data_update_param.setData(data)
    form_data_update_param.setDataId('62a84cefd66b59a440060227')
    result = form_data_demo.singleDataUpdate(form_data_update_param)
    print('singleDataUpdate result:', result)


# 测试 删除单条数据接口
def singleDataRemove():
    form_data_delete_param = FormDataDeleteParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    form_data_delete_param.setDataId('62a7e9b2eb048590fc94dde8')
    result = form_data_demo.singleDataRemove(form_data_delete_param)
    print('singleDataRemove result:', result)


# 测试 新建多条数据接口
def batchDataCreate():
    form_data_batch_create_param = FormDataBatchCreateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    data = {}
    # 数字
    data['_widget_1654848548501'] = {'value': 321}
    # 单行文本
    data['_widget_1654848548482'] = {'value': '单行文本2333'}
    # 地址
    address = {'city': '北京市', 'province': '北京市', 'district': '东城区', 'detail': '详细地址'}
    data['_widget_1654848578745'] = {'value': address}
    # 日期
    data['_widget_1654848591194'] = {'value': 1654876800000}
    data_list = []
    data_list.append(data)
    data_list.append(data)
    form_data_batch_create_param.setDataList(data_list)
    result = form_data_demo.batchDataCreate(form_data_batch_create_param)
    print('batchDataCreate result:', result)


# 测试 查询多条数据接口
def batchDataQuery():
    form_data_query_param = FormDataQueryParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    # 从 62a2fc6f5e66850006738f73 这条数据开始 查找10条数据
    form_data_query_param.setDataId('62a2fc6f5e66850006738f73')
    form_data_query_param.setLimit(10)
    # 只查这两个字段
    form_data_query_param.setFields(["_widget_1654848548482", "_widget_1654848548501"])
    # 过滤条件
    filter = {}
    # 关系是 and
    filter['rel'] = 'and'
    condList = [{'field': '_widget_1654848548482', 'type': 'text', 'method': 'eq', 'value': ['单行文本1']}]
    filter['cond'] = condList
    form_data_query_param.setFilter(filter)
    result = form_data_demo.batchDataQuery(form_data_query_param)
    print('batchDataQuery result:', result)


# 测试 删除多条数据接口
def batchDataRemove():
    data_ids = ['62a309ad5cb2173054a96148', '62a309ad5cb2173054a96147']
    result = form_data_demo.batchDataRemove(HttpConstant.APP_ID, HttpConstant.ENTRY_ID, data_ids)
    print('batchDataRemove result:', result)


def batchDataUpdate():
    form_data_batch_update_param = FormDataBatchUpdateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
    form_data_batch_update_param.setDataIds(['62a303185cb2173054a96104', '62a302a75cb2173054a960f2'])
    # 仅将 _widget_1654848548501 这个字段的值改成2
    data = {'_widget_1654848548501': {'value': 2}}
    form_data_batch_update_param.setData(data)
    result = form_data_demo.batchDataUpdate(form_data_batch_update_param)
    print('batchDataUpdate result:', result)


if __name__ == '__main__':
    singleDataCreate()
    # singleDataQuery()
    # singleDataUpdate()
    # singleDataRemove()
    # batchDataCreate()
    # batchDataQuery()
    # singleDataRemove()
    # batchDataUpdate()
