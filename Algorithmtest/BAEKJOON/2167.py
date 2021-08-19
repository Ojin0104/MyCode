N,M=list(map(int,input().split(" ")))
box=[list(map(int,input().split(" "))),list(map(int,input().split(" ")))]
iter=int(input())
for c in range(iter):
    i,j,x,y=list(map(int,input().split(" ")))
    sum=0
    for b in range(i-1,x):
        for d in range(j-1,y):
            sum+=box[b][d]
           
    print(sum)