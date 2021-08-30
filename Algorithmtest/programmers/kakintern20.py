def solution(gems):#이진탐색으로 적정한부분 set으로 찾아서 해보자
    nums=len(set(gems))
    
    if nums==len(gems):
        return [1,len(gems)]
    while True:#nums를 늘려줌으로써 한번에 탐색하는 범위를 늘려줘 자연스럽게 작은범위의 결과값을 먼저 return
        
        for i in range(len(gems)-nums+1):#보석찾는 시작 부분 
            if len(set(gems))==len(set(gems[i:nums+i])):
                return [i+1,i+nums]
        nums+=1
gems=["A","B","B","B","B","B","B","C","B","A"]
print(solution(gems))