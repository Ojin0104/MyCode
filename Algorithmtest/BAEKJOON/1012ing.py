TC=int(input())
def dfs(i,j):
    dx=[0,1,0,-1]
    dy=[-1,0,1,0]
    for c in range(4):
        if dy[c]+i<0 or dx[c]+j<0 or dx[c]+j>=M or dy[c]+i>=N:
            pass
        else:
            if G[dy[c]+i][dx[c]+j]==1:
                if Check[dy[c]+i][j+dx[c]]==0:
                    Check[dy[c]+i][j+dx[c]]=1
                    dfs(dy[c]+i,dx[c]+j)


for t in range(TC):
    M,N,K=map(int,input().split(" "))
    count=0
    G=[[0 for i in range(M)] for j in range(N)]
    
    Check=[[0 for i in range(M)] for j in range(N)]
    for s in range(K):
        j,i=map(int,input().split(" "))
        
        G[i][j]=1
    for i in range(N):
        for j in range(M):
            if G[i][j]==1:
                if Check[i][j]==0:
                    Check[i][j]=1
                    dfs(i,j)
                    count+=1
    print(count)
   




    
    
