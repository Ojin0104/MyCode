##민수는 최근 숫자 세기 놀이에 푹 빠져있다. 민수는 숫자를 N진수로 세며, 9보다 큰 숫자는 한자리로 표현하기 위해 아래와 같이 바꾸어서 센다.

##10 ~ 35: a~z (알파벳 소문자)
# # 36 ~ 61: A~Z (알파벳 대문자)
# # 민수가 N진수의 숫자를 start부터 end까지 센 결과를 counts라고 할 때, 민수가 잘 못 센 숫자의 개수를 반환하는 함수를 구현하시오.

# # (단, 2 < N <= 62, start < end이며, counts의 길이는 (end - start + 1)이다.)

def solution(N, start, end, counts):
    
    
    def check(stri):#문자열을 10진수 숫자로
        if stri.isdigit():
            num=int(stri)
        elif stri.isupper():
            num=ord(stri)-29
        else:
            num=ord(stri)-87
        return num

    def trans(num):# 숫자를 문자열로 
        if num<10:
            return str(num)
        elif num>=10 and num<=35:
            return str(chr(num+87))
        else:
            return str(chr(num+29))
    
    def findnum(startN,N):
        y=[0 for i in range(startN//N+2)]
        y[0]=""
        i=1
        while startN>0:#N진법의 각자리값을 십진법으로 변환
            y[i]=str(startN%N)+y[i-1]
            startN//=N
            i+=1
            y.reverse()
            y.pop()#""삭제
        return y

    startnum=check(start)
    endnum=check(end)
    correct=[]
    startN=start
    

    for i in range(endnum-startnum+1):#주어진 리스트개수만큼 
       a= findnum(startnum+i,N)
       
       data=""
       if type(a)==list:
            
            for k in a:#각 리스트 값의 자릿수가 여러자리일수 있으므로 각자리마다 문자열로 바꿔준후 연결
                
                data+=trans(int(k))
                
       else:
           data=trans(a)
      
       correct.append(data)
       
    count=0
    for i in range(len(correct)):#정답체크
        if correct[i]!=counts[i]:
            count+=1
    return count
counts=['9', 'a', 'c', 'd', 'e']
print(solution(14,'9','d',counts))
counts=['Z', '10', '11', '12']
print(solution(62,'Z','12',counts))