def solution(s):
    lst=list(s)
    
    if s=="".join(reversed(lst)):
        return ''
    else:
        
        a=lst[:len(lst)//2]
        
        b="".join(a)+"".join(reversed(a))
        
        return b

print(solution('wabe'))
print(solution('abccba'))