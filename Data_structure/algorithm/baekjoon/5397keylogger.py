##insert사용시 시간복잡도가 O(N)이여서 시간초과가 뜨는듯하다

inp=int(input())
for i in range(inp):
    data=input()
    str=[]
    index=0
    for a in data: 
            if a=='<':
                if index>0:
                    index-=1  
            elif a=='>':
                if index<len(str):
                    index+=1
            elif a=='-':
                if index==0:
                    pass
                else  :                 
                    str.pop(index-1)
                    index-=1
            else:
                str.insert(index,a)
                index+=1
        
    print("".join(str))
    

