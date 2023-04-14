def solution(n, s, a, b, fares):
    answer = 0
    INF=100000*n
    graph=[[INF]*n for _ in range(n)]
    for i in range(n):
        graph[i][i]=0
    for load in fares:
        graph[load[0]-1][load[1]-1]=load[2]
        graph[load[1]-1][load[0]-1]=load[2]
    #인접행렬 세팅
    
    
    #플로이드워셜로 모든 정점 최단거리 계산
    for k in range(n):
        for i in range(n):
            for j in range(n):
                graph[i][j]=min(graph[i][k]+graph[k][j],graph[i][j])
        
    
    
    #합승지점에대한 최단비용계산
    fee=INF
    for i in range(n):
        
        fee=min(fee,graph[s-1][i]+graph[i][a-1]+graph[i][b-1])
    return fee