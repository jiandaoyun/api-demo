import uuid


class HttpRequestParam:
    def __init__(self, path, data):
        self.path = path
        self.data = data


def generateTransactionId():
    return str(uuid.uuid4())
