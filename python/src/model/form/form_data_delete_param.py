class FormDataDeleteParam:
    def __init__(self, app_id, entry_id):
        self.app_id = app_id
        self.entry_id = entry_id

    def setDataId(self, data_id):
        self.data_id = data_id

    def setIsStartTrigger(self, is_start_trigger):
        self.is_start_trigger = is_start_trigger

    def setDataIds(self, data_ids):
        self.data_ids = data_ids
