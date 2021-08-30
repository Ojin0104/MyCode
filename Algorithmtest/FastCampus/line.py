from collections import deque
def solution(C, B):
    time=0
    visit=[[0,0] for _ in range(200001)]
    q=deque()
    q.append((B,0))
    
    
    while True:
        C+=time

        if C>200000:
            return -1
        if visit[C][time%2]:#방문한적있다면 time return
            return time

        for i in range(len(q)):
            current=q.popleft()
            currentPosition=current[0]
            newTime=(current[1]+1)%2

            newPosition=currentPosition -1
            if newPosition>=0 and not visit[newPosition][newTime]:
                visit[newPosition][newTime]=True
                q.append((newPosition,newTime))

            newPosition=currentPosition+1
            if newPosition<200001 and not visit[newPosition][newTime]:
                visit[newPosition][newTime]=True
                q.append((newPosition,newTime))

            newPosition=currentPosition*2
            if newPosition<200001 and not visit[newPosition][newTime]:
                visit[newPosition][newTime]=True
                q.append((newPosition,newTime))
        time+=1
    
 
print(solution(11, 2))