



myedges=[ 
    (7,'A','B'),(5,'A','D'),#양끝 노드 간선 모두 표시
    (8,'B','C'),(9,'B','D'),(7,'B','E'),
    (5,'C','E'),
    (7,'D','E'),(6,'D','F'),
    (8,'E','F'),(9,'E','G'),
    (11,'F','G')
]
from collections import defaultdict
from heapq import *
def prim(start_node,edges):
    mst=list()
    adjacent_edges=defaultdict(list)
    for weight,n1,n2 in edges:#그냥 A,B연결된게 B,A연결된거 같아서 둘다표시해줌
        adjacent_edges[n1].append((weight,n1,n2))
        adjacent_edges[n2].append((weight,n2,n1))
    connected_nodes=set(start_node)
    candidate_edge_list=adjacent_edges[start_node]
    heapify(candidate_edge_list) #가중치가 가장 낮은 간선 표시

    while candidate_edge_list:
        weight,n1,n2=heappop(candidate_edge_list)#가중치낮은 간선 추출
        if n2 not in connected_nodes:
            connected_nodes.add(n2)#연결된 노드들 추가
            mst.append((weight,n1,n2))

            for edge in adjacent_edges[n2]:
                if edge[2] not in connected_nodes:#heappush의 시간복잡도 떄문에 효율성위해 넣어줌
                    heappush(candidate_edge_list,edge)
    return mst
prim('A',myedges)