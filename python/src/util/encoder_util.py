from json import JSONEncoder


class MyEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
