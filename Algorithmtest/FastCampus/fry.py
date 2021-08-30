#철수는 개발자에서 은퇴하여 치킨집을 하게 되었다. 철수는 뛰어난 개발 실력으로 N대의 자동 튀김기를 만들어냈다. 
# i번째 자동 튀김기는 치킨을 한 번 튀기는 데에 fry[i] 만큼의 시간이 걸리며, 튀김이 한번 끝나면 clean[i] 만큼의 시간동안 자동 세척을 한다.

#철수가 C 번 치킨을 튀겨내려고 할 때, 최소한 몇 시간 동안 자동 튀김기를 가동해야 하는지 계산하시오.
#나는 시간을 반복해서 그시간에 몇개치킨 튀기는지 해서 구했지만 더좋은 방법이 있을 것 같다.
# 
def solution(N, fry, clean, C):
    left = 0
    right = C * max([x+y for x, y in zip(fry, clean)])
    answer = right
 
    while left <= right:
        mid = (left + right) // 2
 
        val = 0
        for f, c in zip(fry, clean):
            val += (mid + c) // (f + c)
 
        if val >= C:
            right = mid - 1
            answer = min(answer, mid)
        else:
            left = mid + 1
 
    return answer
 
N = 2
fry = [3, 6]
clean = [2, 1]
C = 20
print(solution(N, fry, clean, C))
 
N = 4
fry = [2, 2, 1, 3]
clean = [2, 4, 3, 2]
C = 2
print(solution(N, fry, clean, C))

#def solution(N, fry, clean, C):
#     t=0
#     while True:
#         t+=1
#         nums=0
#         for i in range(N):
            
#             if t-fry[i]>=0:
#                 nums+=1
#                 nums+=(t-fry[i])//(fry[i]+clean[i])
#                 if nums==C:
#                     return t
  
# fry=[3, 6]
# clean=[2, 1]
# C=20
# N=2
# print(solution(N, fry, clean, C))
# fry=[2,2,1,3]
# clean=[2,4,3,2]
# C=2
# N=4
# print(solution(N, fry, clean, C))