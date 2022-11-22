class FormDataQueryParam:
    def __init__(self, app_id, entry_id):
        self.app_id = app_id
        self.entry_id = entry_id

    def setDataId(self, data_id):
        self.data_id = data_id

    def setLimit(self, limit):
        self.limit = limit

    def setFields(self, fields):
        self.fields = fields

    def setFilter(self, filter):
        self.filter = filter
