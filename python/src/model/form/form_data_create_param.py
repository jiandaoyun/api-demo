class FormDataCreateParam:
    def __init__(self, app_id, entry_id):
        self.app_id = app_id
        self.entry_id = entry_id

    def setData(self, data):
        self.data = data

    def setIsStartWorkFlow(self, is_start_workflow):
        self.is_start_workflow = is_start_workflow

    def setIsStartTrigger(self, is_start_trigger):
        self.is_start_trigger = is_start_trigger

    def setTransaction_id(self, transaction_id):
        self.transaction_id = transaction_id
