def find(x):
    if x==parent[x]:
        return x
    else:
        p=find(parent[x])
        parent[x]=p
        return parent[x]

def union(x,y):
    x=find(x)
    y=find(y)
    if x!=y:
        parent[y]=x
        num[x]+=num[y]
        
times=int(input())
for i in range(times):
    person=int(input())
    num={}
    parent={}
   
    for t in range(person):
        x,y=list(input().split(" "))
        if x not in parent:
            parent[x]=x
            num[x]=1
        if y not in parent:
            parent[y]=y
            num[y]=1
        union(x,y)
        print(parent)
        print(num)
        print(num[find(x)])
        

            

            
       
            
            
            
        
            