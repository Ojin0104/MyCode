# 정수가 리스트로 주어질때 어떻게 배치하여야 큰수가나오는지 ex[6,10,2]에서 6210이 가장큰수
def solution(numbers):
    
    
    def perm(numbers): 
      
      a=numbers
      lengths=len(a)
      if lengths == 1: 
        return [a] 
      
      else: 
        result = [] 
        for i in a: 
          b = a.copy() 
          b.remove(i) 
          b.sort() 
          for j in perm(b): 
            j.insert(0, i) 
            if j not in result: 
              result.append(j) 
      return result
    
    b=perm(numbers)
    
    lens=len(b[0])
    answer=0
    for k in b:
      
      stri=""
      for s in range(lens):
        stri+=str(k[s])
      if answer<int(stri):
        answer=int(stri)
    return str(answer)
numbers=[6,10,2]
print(solution(numbers))
numbers=[3,30,34,5,9]
print(solution(numbers))