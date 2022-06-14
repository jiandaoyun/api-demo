class WorkFlowApprovalCommentQueryParam:
    def __init__(self, app_id, entry_id):
        self.app_id = app_id
        self.entry_id = entry_id

    def setData_id(self, data_id):
        self.data_id = data_id

    def setSkip(self, skip):
        self.skip = skip

    def setLimit(self, limit):
        self.limit = limit
