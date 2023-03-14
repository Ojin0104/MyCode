from array import array

def bomb(nowtime):
    global arr
    dx=[1,0,-1,0]
    dy=[0,1,0,-1]
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            if arr[i][j]==nowtime:
                arr[i][j]='.'
                for k in range(4):
                    if dx[k]+i<0 or dy[k]+j<0 or dx[k]+i>=len(arr) or dy[k]+j>=len(arr[0]):
                        
                        continue
                    else:
                        if arr[i+dx[k]][j+dy[k]]!=nowtime:
                            arr[i+dx[k]][j+dy[k]]='.'

    return 0
                

def makebomb(second):
    global arr

    for i in range(len(arr)):
        for j in range(len(arr[i])):
            if arr[i][j]=='.':
                
                arr[i][j]=sec+3
              



R,C,N=map(int,input().split())

global arr
arr=[[ 0 for col in range(C)] for row in range(R)]
sec=1
for i in range(R):
    st=input()
    for j in range(C):
        if st[j]=='O':
            arr[i][j]=3
        else:
            arr[i][j]=st[j]
       
for i in range(N-1):
    sec+=1
    if sec%2==1:
        bomb(sec)
    else:
        makebomb(sec)

print("go")
for i in range(R):
    
    for j in range(C):
        if arr[i][j]!='.':
            arr[i][j]='O'
        print(arr[i][j],end='')
    print()








