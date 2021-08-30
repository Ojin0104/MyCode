#철수와 영희는 함께 여행을 가기로 했다. 단짝인 두 친구는 계속 붙어다니기로 하고 각자의 짐을 모두 모아서, 두 가방에 적절하게 함께 나누어 담기로 했다. 즉, 총 N개의 짐을 무게 K1, K2만큼 담을 수 있는 가방에 각각 나누어 담고자 한다. i번째 짐의 무게와 가치가 각각 W[i]와 V[i]로 주어졌을 때, 두 사람이 담을 수 있는 짐의 가치의 합 중 최대값을 구하시오.

#입출력 예시
#N	K1	K2	W	             V	           return
#4	3	8	[1, 5, 6, 3]	[5, 2, 14, 6]	25
def solution(N, K1, K2, W, V):
    dp = [[[0 for _ in range(K2 + 1)]
                for _ in range(K1 + 1)]
                    for _ in range(2)]
 
    for i in range(N):
        for k1 in range(K1 + 1):
            for k2 in range(K2 + 1):
                val1, val2 = 0, 0
                if k1 >= W[i]:
                    val1 = dp[(i-1)%2][k1 - W[i]][k2] + V[i]
                if k2 >= W[i]:
                    val2 = dp[(i-1)%2][k1][k2 - W[i]] + V[i]
                dp[i%2][k1][k2] = max(dp[(i-1)%2][k1][k2], val1, val2)
 
    return dp[(N-1)%2][K1][K2]
 
N = 4
K1 = 3
K2 = 8
W = [1, 5, 6, 3]
V = [5, 2, 14, 6]
print(solution(N, K1, K2, W, V))