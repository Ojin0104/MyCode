import hashlib

inp=input()
data=inp.encode()
result=hashlib.sha256(data).hexdigest()
print(result)