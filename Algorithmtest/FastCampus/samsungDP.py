def solution(N, duration, cost):##dp 는 뒤에서부터 가장 많은 cost를 얻을수 있는 값
    dp = [0]*(N+1)
 
    def dynamic_programming():
        max_val = 0
        for i in range(N-1, -1, -1):
           if duration[i]+i>N:##기간넘겨버리는 값 제외
               pass
           else:
               dp[i]=max(dp[duration[i]+i:])+cost[i]##i번째 일을 하는 기간 뒤의 dp값중 가장 큰값과 더해줌
           
        max_val=max(dp)
        return max_val
 
    result = dynamic_programming()
    return result
 
 
N = 7
duration = [3, 5, 1, 1, 2, 4, 2]
cost = [10, 20, 10, 20, 15, 40, 200]
print(solution(N, duration, cost))
 
N = 10
duration = [5, 4, 3, 2, 1, 1, 2, 3, 4, 5]
cost = [50, 40, 30, 20, 10, 10, 20, 30, 40, 50]
print(solution(N, duration, cost))