
load={}
arrive={}
minnum=10000000
answer=[]
check=[]
def solution(n, paths, gates, summits):
    global load
    global arrive
    global minnum
    global answer
    global check
    
    check=[False]*n
    for path in paths:#봉우리까지 간거의 *2
        if path[0] in load:
            load[path[0]].append([path[1],path[2]])
        else:
            load[path[0]]=[]
            load[path[0]].append([path[1],path[2]])
    #print(load)
    for summit in summits:
        arrive[summit]=True
    print(answer[0])
    for gate in gates:
        dfs(gate,minnum)
        
    
    
    return answer


def dfs(street,intensity):
    global minnum
    global answer
    if street in arrive:
        if intensity<minnum:
            answer=[street,intensity]
            minnum=intensity
            
        if intensity==minnum:
            if answer[0]>street:
                
                answer=[street,intensity]
                minnum=intensity
                
        return
    
    
    if street in load:  
       
        for st in load[street]:
            
            if minnum>=st[1]:
                if check[street]==False:
                    check[street]=True
                    dfs(st[0],max(st[0],intensity))
                    check[street]=False
        
n=6
paths=[[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]
gates=[1, 3]
summits=[5]

solution(n,paths,gates,summits)