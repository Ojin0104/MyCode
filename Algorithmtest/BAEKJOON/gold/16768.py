##del list를 사용하는 방법으로 행과열을 바꾸어 주고 열에서 0을 정리해주는 방법으로함
N,K=map(int,input().split(" "))
M=[(list(input())) for _ in range(N)]

def dfs(i,j,del_lst):
    if check[i][j]==1:
        pass
    else:
        dx=[0,1,0,-1]
        dy=[-1,0,1,0]
        check[i][j]=1
        
        del_lst.append([i,j])
        for k in range(4):
            if 0<=i+dy[k]<10 and 0<=j+dx[k]<N:
                
                if new_M[i][j]==new_M[i+dy[k]][j+dx[k]]:
                    
                    dfs(i+dy[k],j+dx[k],del_lst)
        
        return del_lst
            
# 밑에 부터 0이있으면 내려주기
new_M=list(map(list,zip(*M)))
for i in range(10):
    for j in range(1,N):#반대로
        if new_M[i][j]=='0':
            
            del new_M[i][j]
            new_M[i].insert(0,'0')

while True:
    check=[[0 for _ in range(N)] for _ in range(10)]
    t=False#t변화없으면 while break
    for i in range(10):
        for j in range(N):
            if new_M[i][j]!='0' and check[i][j]==0:
                
                lst=[]
                del_lst=dfs(i,j,lst)
                
                if len(del_lst)>=K:
                    for c in del_lst:
                        
                        new_M[c[0]][c[1]]='0'

    for i in range(10):#0내려주기
        change=False
        for j in range(1,N):#반대로
            if new_M[i][j]!='0':
                change=True
            if new_M[i][j]=='0' and change:
                t=True
                del new_M[i][j]
                new_M[i].insert(0,'0')
    if t==False:
        break

last=list(map(list,zip(*new_M)))
for i in range(len(last)):
    print("".join(last[i])) 



