iters=int(input())
tri=[[0 for i in range(iters)] for k in range(iters+1)]
plus=[[0 for i in range(iters)] for k in range(iters+1)]

for i in range(1,iters+1):
    lst=[]
    
    lst=list(map(int,input().split(" ")))
    for j in range(len(lst)):
        tri[i][j]=lst[j]
        plus[i][j]=max(plus[i-1][j-1],plus[i-1][j])+tri[i][j]
print(max((plus[len(plus)-1])))


    