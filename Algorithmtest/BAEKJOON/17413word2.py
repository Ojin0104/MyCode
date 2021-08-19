strs=input()
a=[]
sta=[]
cap=0
for t,i in enumerate(strs):
    
    if i=="<":
        if len(sta)>=1:
            sta.reverse()
            
            for c in range(len(sta)):
                a.append(sta[c])

            sta=[]
        cap=1
        a.append(i)

        continue
        
    elif i==">":
        cap=0
        a.append(i)
        continue
    
    if cap:
        a.append(i)
    else:
        if t==len(strs)-1:
            sta.append(i)
        if i==" " or t==len(strs)-1:
            sta.reverse()
            
            for c in range(len(sta)):
                a.append(sta[c])
                
            a.append(" ")
            sta=[]
            continue
        
        
        sta.append(i)

print(''.join(a))
    

