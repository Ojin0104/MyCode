num=int(input())
data=set(map(int,input().split(' ')))
fnum=int(input())
fdata=list(map(int,input().split(' ')))

for i in fdata:
    if i not in data:
        print(0)
    else:
        print(1)
