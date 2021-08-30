 #뱀이있는 곳 1로표시 사과있는곳 2 뱀이 사과지나가면 원래 부분 두고 사과만 1로바꿈 -> 길이늘어남
#
#머리방향 0 오 1 아 2 왼 3 위 머리방향에따라 if문써서 이동 다르게
def solution(N,K,L,apples,moves):
    
    A=[[0 for _ in range(N+1)] for k in range(N+1)]
    A[1][1]=1
    head=0
    tailhead=0
    time=0
    tail=[1,1]
    change_tail=[]
    i,j=1,1

    
    for apple in apples:
        
        x=apple[0]
        y=apple[1]
        A[x][y]=2


    
    
    while True:
        time+=1
        
        #꼬리방향
        if len(change_tail)>=1:
            if change_tail[0][0]==tail[0] and change_tail[0][1]==tail[1]:
                tailhead=change_tail[0][2]
                del change_tail[0]

        
        if head==0:
            j+=1
        elif head==1:
            i+=1
        elif head==2:
            j-=1
        else:
            i-=1

        if i>N or i <1 or j>N or j<1: # 벽 부딪힘
            
            return time
            
            
        if A[i][j]==0:
            A[i][j]=1
            A[tail[0]][tail[1]]=0
            if tailhead==0:
                tail[1]+=1
            elif tailhead==1:
                tail[0]+=1
            elif tailhead==2:
                tail[1]-=1
            else:
                tail[0]-=1
            
        elif A[i][j]==1:
            
                return time
            

            
        elif A[i][j]==2:
            A[i][j]=1
        
        ##머리방향
        for t in moves:
            if time==int(t[0]):
                if t[1]=='D':
                    
                    head=(head+1)%4
                    change_tail.append([i,j,head])
                elif t[1]=='L':
                    head=(head-1)%4
                    change_tail.append([i,j,head])
                else:
                    print("trash")
        
N = 6
K = 3
L = 3
apples = [(3, 4), (2, 5), (5, 3)]
moves = [(3, 'D'), (15, 'L'), (17, 'D')]
print(solution(N, K, L, apples, moves))
 
N = 10
K = 4
L = 4
apples = [(1, 2), (1, 3), (1, 4), (1, 5)]
moves = [(8, 'D'), (10, 'D'), (11, 'D'), (13, 'L')]
print(solution(N, K, L, apples, moves))
 
N = 10
K = 5
L = 4
apples = [(1, 5), (1, 3), (1, 2), (1, 6), (1, 7)]
moves = [(8, 'D'), (10, 'D'), (11, 'D'), (13, 'L')]
print(solution(N, K, L, apples, moves))
    
    




    
