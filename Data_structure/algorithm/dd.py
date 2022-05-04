def fibo_dyn(num,fibos):
    if(num==0 or num==1):
        return 1

    if(fibos[num]!=-1):
        return fibos[num]
    else:
        fibos[num]=fibo_dyn(num-1,fibos)+fibo_dyn(num-2,fibos)
        return fibos[num]

fibos=[]
for i in range(1001):
    fibos.append(-1)

print(fibo_dyn(999,fibos))