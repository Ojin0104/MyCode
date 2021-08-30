def solution(words, queries):
    answer = []
    
    for q in queries:
        right=[]
        
        for i in words:
            if len(i)==len(q):
                
                    for k in range(len(q)):
                        cancle=0
                        if i[k]==q[k] or q[k]=="?":
                            pass
                        else:
                            cancle=1
                            break
                    if cancle==0:
                        right.append(i)
        print(right)
        answer.append(len(right))

            
        
    return answer
 
words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
print(solution(words, queries))