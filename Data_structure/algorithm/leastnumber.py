#최소 공배수
A = 'ababababab'
B = 'abab'
def gcdString(A, B):
  alen=len(A)
  blen=len(B)
  
  if blen>alen:
    l=alen
    if blen%alen ==0:#딱나눠 떨어졌을떄는 두문자의 길이가 같거나 반으로 나눈것이 같은 경우이므로
                calsize=int(blen/alen)
    else:
                calsize=1#딱나눠 떨어지지않았을떄는 아래의 while 문을 이용해 딱나눠떨어질떄를 구함
  else:
    l=blen
    if alen%blen ==0:
                calsize=int(alen/blen)
    else:
                calsize=1


  for i in range(l):#작은 문자열을 기준으로 값이 같은기 검사해봄 
    if(A[i]!=B[i]):
      return "' '"
  X=A[0:l]
  
  size=l
  
  while(size>0):
    
    if alen<blen:
       
        if X*calsize==B:
            return X
        else:
            
            
            size=int(size/2)
            X=A[0:size]
            calsize=int(len(B)/len(X))
    else:
        
        if X*calsize==A:
            return X
            
        else:
            size=int(size/2)
            
            X=B[0:size]
            
            calsize=int(len(A)/len(X))
            
  print(size)
  return X

print(gcdString(A, B))


