times=int(input())


for i in range(times):
    num=int(input())
    candy=list(map(int,input().split(" ")))
    for k in range(num):
        if candy[k]%2==1:
            candy[k]+=1
    
    change=[0 for i in range(num)]
    
    count=0
    while(len(set(candy))!=1):
        count+=1
        
        for t in range(num):
            if t==0:             
                change[t]=candy[len(candy)-1]/2+candy[t]/2
            else:
                
                change[t]=candy[t]/2+candy[t-1]/2
                
                
              
       
        for i in range(num):
            candy[i]=change[i]
        for k in range(num):
            if candy[k]%2==1:
                candy[k]+=1
        
    print(count)    
