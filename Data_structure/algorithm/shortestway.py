import heapq

mygraph={
    'A':{'B':8,'C':1,'D':2},
    'B':{},
    'C':{'B':5,'D':2},
    'D':{'E':3,'F':5},
    'E':{'F':1},
    'F':{'A':5}
}
def dijkstra(graph,start):
    distances={node:float('inf') for node in graph}
    distances[start]=0
    queue=[]

    heapq.heappush(queue,[distances[start],start])

    while queue:
        current_distance,current_node=heapq.heappop(queue)
 
        if distances[current_node]<current_distance:
            continue#새로들어올 거리가 기존거리보다 크다면바로 끝

        for adjacent,weight in graph[current_node].items():
            distance=current_distance+weight
            if distance<distances[adjacent]:
                distances[adjacent]=distance
                heapq.heappush(queue,[distance,adjacent])

    return distances
print(dijkstra(mygraph,'A'))
for a in range(10):
    print(a)