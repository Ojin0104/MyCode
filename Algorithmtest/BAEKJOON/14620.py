#from operator import itemgetter

#sum 의 값이 같을때?
N=int(input())#모든 가능한 부분 sum 구하고 되는 것끼리 되는조건으로구하기 구할떄 (sum,i,j)로 구한후 sum을 기준으로 낮은 수부터세개씩 조합하여 되는거 바로 return 도ㅣ는 줄 알았으나 sum의 값이같을떄가 있어서 small값 비교해줌그냥
G=[list(map(int,input().split(" "))) for _ in range(N)]
M=[]
dx=[0,1,0,-1]
dy=[-1,0,1,0]
def check(x,y):
    if -1<=x[0]-y[0]<=1 and -1<=x[1]-y[1]<=1: #한칸차이인경우
        return True
    elif (x[0]-y[0]==0 and abs(x[1]-y[1])==2) or (abs(x[0]-y[0])==2 and x[1]-y[1]==0):#위아래나 옆으로 2칸차이날때
        return True
    else:
        return False
for i in range(N):
    for j in range(N):
        
        sum=G[i][j]
        
        for k in range(4):
            yy=i+dy[k]
            xx=j+dx[k]
            if yy>=0 and xx>=0 and xx<N and yy<N:

                sum+=G[yy][xx]
            else:
                sum=0
                break
        if sum!=0:
            
            M.append([sum,i,j])

#M.sort(key=itemgetter(0))
small=0
for i in range(N):
    for j in range(N):
        small+=G[i][j]

for i in range(len(M)):
    for j in range(i+1,len(M)):
        if  check(M[i][1:],M[j][1:]):
                continue
        else:#i와 j 가 안되는 조합이면바로 다음 j로
            for k in range(j+1,len(M)):   
                if check(M[i][1:],M[k][1:]):      
                    continue
                elif check(M[j][1:],M[k][1:]):
                    continue
                else:
                    if small>M[i][0]+M[j][0]+M[k][0]:
                        small=M[i][0]+M[j][0]+M[k][0]
                    
print(small)
            
        

