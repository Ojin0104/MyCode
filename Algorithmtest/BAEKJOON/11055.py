import copy
iters=int(input())
lst=list(map(int,input().split(" ")))

cop=copy.deepcopy(lst)#cop[i] i번째 까지의 증가수열의 합 i번쨰가 포함되어야함

for i in range(1,iters):
    for j in range(i):
        if lst[i]>lst[j]:#그 조건으로 i번쨰가 최대값이 되기 위해 j보다 커야함 그럴떄만 아래식 적용
            cop[i]=max(lst[i]+cop[j],cop[i])#조건 만족한는 값에서 가장큰값구함 (j번째 합 +i번째,이전 반복문에서 얻은 i번째합)

print(cop)