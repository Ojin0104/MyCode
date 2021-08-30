import copy
N=int(input())
Z=[list(map(int,input().split(" "))) for _ in range(N)]

case=[]
for a in range(4):
    for b in range(4):
        for c in range(4):
            for d in range(4):
                for e in range(4):
                    case.append([a,b,c,d,e])
maxs=[]
for i in case:
    M=[]
    M=copy.deepcopy(Z)
    
    for j in range(5):
        #위로
        if i[j]==0:
            new_M=list(map(list,zip(*M)))

            for a in range(N):
                for b in range(N-1,-1,-1):
                    if new_M[a][b]==0: 
                        del new_M[a][b]
                        new_M[a].append(0)
                for b in range(N-1):
                    
                    if new_M[a][b]==new_M[a][b+1]: 
                        new_M[a][b]=2*new_M[a][b]
                        new_M[a][b+1]=0

            
                for b in range(N-1,-1,-1):
                    if new_M[a][b]==0:
                        del new_M[a][b]
                        new_M[a].append(0)
            M=list(map(list,zip(*new_M)))
            
        elif i[j]==1:
            #오른쪽
            for a in range(N):
                for b in range(N):
                    if M[a][b]==0:
                        del M[a][b]
                        M[a].insert(0,0)
                for b in range(N-1,0,-1):
                
                    
                    if M[a][b-1]==M[a][b]:
                        M[a][b]=2*M[a][b]
                        M[a][b-1]=0
         
                for b in range(N):
                    if M[a][b]==0:
                        del M[a][b]
                        M[a].insert(0,0)

        
        elif i[j]==2:
            
        #아래쪽
            new_M=list(map(list,zip(*M)))

            for a in range(N):
                for b in range(N):
                    if new_M[a][b]==0: 
                        del new_M[a][b]
                        new_M[a].insert(0,0)
                for b in range(N-1,0,-1):
                   
                    if new_M[a][b-1]==new_M[a][b]:
                        new_M[a][b]=2*new_M[a][b]
                        new_M[a][b-1]=0
                

            
                for b in range(N):
                    if new_M[a][b]==0:
                        del new_M[a][b]
                        new_M[a].insert(0,0)
            M=list(map(list,zip(*new_M)))

        else:#왼쪽
            for a in range(N):
                for b in range(N-1,-1,-1):
                    if M[a][b]==0:
                        del M[a][b]
                        M[a].append(0)
                for b in range(N-1):
                
                   
                    if M[a][b]==M[a][b+1]: 
                        M[a][b]=2*M[a][b]
                        M[a][b+1]=0
            
            
                for b in range(N-1,-1,-1):
                    if M[a][b]==0:
                        del M[a][b]
                        M[a].append(0)
    
    ma=max(map(max,M))
    maxs.append(ma)

print(max(maxs))

            
        
