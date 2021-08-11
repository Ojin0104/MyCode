N,L,K=list(map(int,input().split(' ')))
trys,point=0,0
en=0
hn=0
for i in range(N):

    easy,hard=list(map(int,input().split(' ')))
    
    if hard<=L:
        hn+=1
            
    elif easy<=L:
        en+=1
    
point=min(hn,K)*140
if hn<K:
    point+=min(K-hn,en)*100
print(point)