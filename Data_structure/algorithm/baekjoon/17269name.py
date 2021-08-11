x,y=map(int,input().split())
A,B=input().split()

num=[3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1]
# shake=[]
# if x>y:
#     for i in range(x):
#         shake.append(A[i])
#         if i<y:
#             shake.append(B[i])
# else:
#     for i in range(y):
#         if i<x:
#             shake.append(A[i])
#         shake.append(B[i])
# index=[]

# for i in range(len(shake)):
    
#     index.append(num[ord(shake[i])-ord('A')])

# while True:
    
#     per=[]
#     for i in range(len(index)-1):
#         per.append((index[i]+index[i+1])%10)
#     if len(per)==2:
#         break

#     index=[]
#     index=per
    
# hey=int(str(per[0])+str(per[1]))
# print(hey,end='')
# print("%")   
AB=''
min_len=min(x,y) 
for i in range(min_len):
    AB+=A[i]+B[i]
AB+=A[min_len:]+B[min_len:]
lst=[num[ord(i)-ord('A')] for i in AB]

for i in range(x+y-2):
    for j in range(x+y-1-i):
        lst[j]+=lst[j+1]
print("{}%".format(lst[0]%10*10+lst[1]%10))




