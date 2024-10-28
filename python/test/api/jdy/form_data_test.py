import unittest
from unittest.mock import patch

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

data_id = "671619c7cda20728e6d89c52"
data_ids = ["671619c7cda20728e6d89c53", "671619c7cda20728e6d89c54"]

class TestSendEmail(unittest.TestCase):
    # 测试 新建单条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_single_data_create(self, mock_send_post):
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
        formDataApiClient.singleDataCreate(form_data_create_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/create")
        self.assertEqual(request_param.data.data, data)

    # 测试 查询单条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_single_data_query(self, mock_send_post):
        form_data_query_param = FormDataQueryParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        form_data_query_param.setDataId(data_id)
        formDataApiClient.singleDataQuery(form_data_query_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/get")
        self.assertEqual(request_param.data.data_id, data_id)


    # 测试 修改单条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_single_data_update(self, mock_send_post):
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
        formDataApiClient.singleDataUpdate(form_data_update_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/update")
        self.assertEqual(request_param.data.data, data)
        self.assertEqual(request_param.data.data_id, data_id)


    # 测试 删除单条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_single_data_remove(self, mock_send_post):
        form_data_delete_param = FormDataDeleteParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        form_data_delete_param.setDataId(data_id)
        formDataApiClient.singleDataRemove(form_data_delete_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/delete")
        self.assertEqual(request_param.data.data_id, data_id)


    # 测试 新建多条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_batch_data_create(self, mock_send_post):
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
        formDataApiClient.batchDataCreate(form_data_batch_create_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/batch_create")
        self.assertEqual(request_param.data.data_list, data_list)


    # 测试 查询多条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_batch_data_query(self, mock_send_post):
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
        formDataApiClient.batchDataQuery(form_data_query_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/list")
        self.assertEqual(request_param.data.filter, filter)


    # 测试 删除多条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_batch_data_remove(self, mock_send_post):
        form_data_delete_param = FormDataDeleteParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        form_data_delete_param.setDataIds(data_ids)
        formDataApiClient.batchDataRemove(form_data_delete_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/batch_delete")
        self.assertEqual(request_param.data.data_ids, data_ids)


    # 测试 更新多条数据接口
    @patch.object(formDataApiClient, 'send_post')
    def test_batch_data_update(self, mock_send_post):
        form_data_batch_update_param = FormDataBatchUpdateParam(HttpConstant.APP_ID, HttpConstant.ENTRY_ID)
        form_data_batch_update_param.setDataIds(data_ids)
        # 仅将 _widget_1654848548501 这个字段的值改成2
        data = {num_widget: {'value': 2}}
        form_data_batch_update_param.setData(data)
        formDataApiClient.batchDataUpdate(form_data_batch_update_param)
        request_param = mock_send_post.call_args[0][0]
        self.assertEqual(request_param.data.app_id, HttpConstant.APP_ID)
        self.assertEqual(request_param.data.entry_id, HttpConstant.ENTRY_ID)
        self.assertEqual(request_param.path, "/v5/app/entry/data/batch_update")
        self.assertEqual(request_param.data.data, data)
        self.assertEqual(request_param.data.data_ids, data_ids)