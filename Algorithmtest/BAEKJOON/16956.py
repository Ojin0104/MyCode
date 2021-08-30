R,C=map(int,input().split())
M=[list(input()) for i in range(R)]

dx=[0,1,0,-1]#0 위 1 오 2 아 3 왼
dy=[-1,0,1,0]

for i in range(R):#행
    for j in range(C):#열
        if M[i][j]=='W':
            
            for k in range(4):
                
                if j+dx[k]<C and i+dy[k]<R and j+dx[k]>=0 and i+dy[k]>=0:
                    if M[i+dy[k]][j+dx[k]]=='S':
                        print(0)
                    elif M[i+dy[k]][j+dx[k]]=='.':
                        M[i+dy[k]][j+dx[k]]='D'
print(1)
for i in M:
    print("".join(i))

