class FormDataBatchUpdateParam:
    def __init__(self, app_id, entry_id):
        self.app_id = app_id
        self.entry_id = entry_id

    def setDataIds(self, data_ids):
        self.data_ids = data_ids

    def setData(self, data):
        self.data = data

    def setTransaction_id(self, transaction_id):
        self.transaction_id = transaction_id
