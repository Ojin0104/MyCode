##전에꺼 방향설정으로 도로 비용계산
# dp 와 dfs 같이 써서 시간복잡도 줄이기
#dp 는 해당위치까지갈때 소요되는 최소 비용
import sys
sys.setrecursionlimit(10000)
minnum=sys.maxsize
dp=[]
def solution(board):
    global dp
    dp=[[sys.maxsize]*len(board) for _ in range(len(board))]
   
    
    dfs(board,0,0,0,0)
    answer = 0
    return minnum

def dfs(board,cost,x,y,d):#d 0은 시작위치 1 위 2 오른 3 아래 4 왼
    global minnum
    global dp
    dp[y][x]=cost
    dir_x=[0,1,0,-1]
    dir_y=[-1,0,1,0]
    
    
    if x==len(board)-1 and y==len(board)-1:
        minnum=min(minnum,cost)
        return
    
    
    for i in range(1,5):
        next_x=x+dir_x[i-1]
        next_y=y+dir_y[i-1]
        if next_x<0 or next_y<0 or next_x>=len(board) or next_y>=len(board):
            continue
        if board[next_y][next_x]==1:
            continue
        if d==0 or i==d:
            addcost=100
        elif abs(i-d)==2:
            continue
        else:
            addcost=600
        if dp[next_y][next_x]<addcost+cost:
            continue
        else:
            dfs(board,cost+addcost,next_x,next_y,i)
    

