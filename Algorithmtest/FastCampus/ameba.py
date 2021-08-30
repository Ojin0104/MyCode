###아메바가 분열하여 두개체가 되는데 1분소모됨
###분열한 아메바의 기존개체는 사라지고 분열후에 하나는 바로분열시작하지만 하나는 1분후에 분열시작
###분열중엔 개체가 남아있는 것으로 하였을떄 
## 아메바가 생겨날떄마다 이름을 짓는다면 몇개의 이름을 지어야할까?
def child(lst,count):
    
    count+=lst[0]*2
    
    ready=lst[0]

    lst[0]+=lst[1]
    lst[1]=ready
    return lst,count
lst=[1,0]##[분열하는 아메바,휴식중인아메바수]
count=1##처음에 아메바하나 존재
N=int(input())
for i in range(N):
    lst,count=child(lst,count)
    
print(count)

    