import copy
i=[[1,2,3],[2,2,2]]
i[1][2]=2*i[0][0]
c=copy.deepcopy(i)
c[1][1]=10
print(i)
print(c)