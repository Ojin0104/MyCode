n=int(input())
stack=[]
result=[]
num=1
for i in range(1,n+1):
    inn=int(input())
    while num<=inn:
        stack.append(num)
        num+=1
        result.append('+')
    if stack[-1]==inn:
        stack.pop()
        result.append('-')
    else:
        print('X')
        exit()

print(result)  
