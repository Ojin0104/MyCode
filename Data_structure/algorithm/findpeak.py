## 숫자가 오름차순으로 올라갔다가 내려가는 리스트에서 
## 최대값 peak가 하나 존재한다고 할때 그 peak 의 값은??
##############################################
def solution(x):
  
 
  if len(x)<=2:
    
    if x[0]>x[1]:
      
      return x[0]
    else:
     
      return x[1]
      
  
  else:
    mid=(len(x))//2
    
    if x[mid]>x[mid+1]:
      
      a=solution(x[:mid+1])
    elif x[mid]<x[mid+1]:
      
      a=solution(x[mid:])
    else:#같을경우
      if x[mid-1]>x[mid]:
        a=solution(x[:mid+1])
      else:
        a=solution(x[mid:])
  return a

x=[-4,-4,-2,0,0,2,4,5,6,3,2,-4,-6]
print(solution(x))
x=[-1, -1, -1, -1, 0, 1, 20, 19, 17]
print(solution(x))