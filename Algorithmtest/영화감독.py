a=input()
if a.isdigit() and 0<int(a)<=10000:
    a=int(a)
    if a==1:
        print(666)
    else:
        print(int(str(a-1)+'666'))