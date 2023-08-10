import copy

def dfs(arr,visit,n):
    global minimum
    if(n==len(visit)):
        minimum=min(minimum,minArr(arr))
        return 
    newArr=copy.deepcopy(arr)
    for i in range(len(visit)):
        if(visit[i]==False):
            visit[i]=True
            
            newArr=change(arr,Q[i][0],Q[i][1],Q[i][2])
            dfs(newArr,visit,n+1)
            visit[i]=False
        


def minArr(a):
    return min([sum(i) for i in a])
        

def change(a,r,c,s):
    #r,c가 중심
    r-=1
    c-=1
    #print(r," ",c)
    newArr=copy.deepcopy(a)
    for i in range(1,s+1):
        for j in range(4):
            for k in range(1,i*2+1):
                newArr[r+i*dx[j]+k*ddx[j]][c+i*dy[j]+k*ddy[j]]=a[r+i*dx[j]+(k-1)*ddx[j]][c+i*dy[j]+(k-1)*ddy[j]]
                

    return newArr


N,M,K=map(int,input().split())

A=[list(map(int,input().split())) for _ in range(N)]
Q=[list(map(int,input().split())) for _ in range(K)]

dx=[-1,1,1,-1]
dy=[1,1,-1,-1]

ddx=[1,0,-1,0]
ddy=[0,-1,0,1]

minimum=10000



visit=[False for i in range(K)]    
    
dfs(A,visit,0)

    
print(minimum)

