class RoleListQueryParam:
    def __init__(self, skip, limit):
        self.skip = skip
        self.limit = limit

    def setHsdDync(self, has_sync):
        # int 类型 选填
        self.has_sync = has_sync

    def setHasInternal(self, has_internal):
        # int 类型 选填
        self.has_internal = has_internal
