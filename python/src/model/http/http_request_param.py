import uuid


class HttpRequestParam:
    def __init__(self, url, data):
        self.url = url
        self.data = data


def generateTransactionId():
    return {'transaction_id': str(uuid.uuid4())}
