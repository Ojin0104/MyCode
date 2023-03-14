from operator import truediv


N= int(input())
A=sorted(list(map(int,input().split())))

answer=0

for i in A:
    if(i<=answer+1):
        answer+=i
    else:
        break
print(answer)



