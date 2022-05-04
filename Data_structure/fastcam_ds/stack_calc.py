class Stack:
    def __init__(self):
        self.list = list()
 
    def push(self, data):
        self.list.append(data)
 
    def pop(self):
        return self.list.pop()
 
class Calculator:
    def __init__(self):
        self.stack = Stack()
 
    def calculate(self, string):
        sltring=string.split(' ')
        slstring=sltring[::-1]#stack활용하기위해 string을 뒤집어서 push 해줌
 
        for a in slstring:
            self.stack.push(a)
        
        num1=None
        while  len(self.stack.list)!=0:#스택의 size만큼 반복을 해줌
            k=self.stack.pop()
            
            if k=='+' or k=='-' or k=='*' or k=='/':#pop한 값이 연산자인경우와 숫자인 경우를 나눔
                #연산활동  연산자이면 숫자로 받아온 값들 연산자에 맞게 계산하고 num1에 넣은후 그다음 숫자를 받을땐 num2에 넣어 이어서 계산할수있게해줌
                if k=='+':
                    num1+=num2
                elif k=='-':
                    num1-=num2
                elif k=='*':
                    num1*=num2
                elif k=='/':
                    num1/=num2
                else:
                    print("무슨부호냐")
            else:##부호아니면 
                if num1==None:
                    num1=int(k)
                    
                else:
                    num2=int(k)
        return num1

        
 
# Test code
calc = Calculator()
print(calc.calculate('4 6 * 2 / 2 +'))
print(calc.calculate('2 5 + 3 * 6 - 5 *'))