import uuid


class HttpRequestParam:
    def __init__(self, api_key, url, data):
        self.apiKey = api_key
        self.url = url
        self.data = data


def generateTransactionId():
    return {'transaction_id': str(uuid.uuid4())}
