N=int(input())
answer=str(N)
if N<10:
    answer='0'+answer
count=1
answer=answer[-1]+str((int(answer[0])+int(answer[1]))%10)
while(int(answer)!=N):
    count+=1
    answer=answer[-1]+str((int(answer[0])+int(answer[1]))%10)

print(count)
