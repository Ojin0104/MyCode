times=int(input())

for i in range(0,times):
    M,N=list(map(int,input().split(" ")))
    que=[]
    for g in range(0,M):
        que.append(g)
    opportunity=list(map(int,input().split(" ")))
    count=1
    real=que[N]
    while(True):
        
        if opportunity[0]==max(opportunity):
            if que[0]==real:
                print(count)
                break
            que.pop(0)
            opportunity.pop(0)
            count+=1
        else:
            b=que[0]
            que.pop(0)
            que.append(b)
            a=opportunity[0]
            opportunity.pop(0)
            opportunity.append(a)
            