#interval을 주고 간격이 겹치면 합쳐주는 알고리즘 단 각 간격은 오름차순으로 정렬되어있다
def solution(intervals):
  new=[]
  for i in range(len(intervals)):
    
    if i==0:
      new.append(intervals[i])
      continue
    if new[len(new)-1][1]>=intervals[i][0]:
      new[len(new)-1][1]=intervals[i][1]
    else:
      new.append(intervals[i])
    
    


  return new
intervals = [[1,4],[4,5]]
print(solution(intervals))


