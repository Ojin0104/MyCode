num=int(input())
sets=set(map(int,input().split(" ")))
numf=int(input())
lst=list(map(int,input().split(" ")))
for i in range(numf):
    if lst[i] in sets:
        print(1)
    else:
        print(0)
# N,A=int(input()),{i:1 for i in map(int,input().split())}
# M=input()
# print(A)
# for i in list(map(int,input().split())):
#     print(A.get(i,0))#A에 i가 있으면 가져오고 없으면 0출력