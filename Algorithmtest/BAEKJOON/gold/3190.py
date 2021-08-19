#뱀이있는 곳 1로표시 사과있는곳 2 뱀이 사과지나가면 원래 부분 두고 사과만 1로바꿈 -> 길이늘어남
#
#머리방향 0 오 1 아 2 왼 3 위 머리방향에따라 if문써서 이동 다르게
#머리가 움직일위치에 있던 꼬리가 앞으로 가면 안부딪힌다고 생각하였으나 부딪힌다는 판정이었음**
N=int(input())
A=[[0 for _ in range(N+1)] for k in range(N+1)]
A[1][1]=1
head=0
tailhead=0
time=0
tail=[1,1]
change_tail=[]
i,j=1,1

K=int(input())
for s in range(K):
    apple=list(map(int,input().split(" ")))
    x=apple[0]
    y=apple[1]
    A[x][y]=2


L=int(input())
turn=[list(input().split(" ")) for _ in range(L)]
while True:
    time+=1
     
    #꼬리방향
    if len(change_tail)>=1:
        if change_tail[0][0]==tail[0] and change_tail[0][1]==tail[1]:
            tailhead=change_tail[0][2]
            del change_tail[0]

    #print(i,j)
   # print(tail)
    if head==0:
        j+=1
    elif head==1:
        i+=1
    elif head==2:
        j-=1
    else:
        i-=1

    if i>N or i <1 or j>N or j<1: # 벽 부딪힘
        
        print(time)
        
        break
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
        
            print(time)
            
            break
        

        
    elif A[i][j]==2:
        A[i][j]=1
    
    ##머리방향
    for t in turn:
        if time==int(t[0]):
            if t[1]=='D':
                
                head=(head+1)%4
                change_tail.append([i,j,head])
            elif t[1]=='L':
                head=(head-1)%4
                change_tail.append([i,j,head])
            else:
                print("trash")
    
   