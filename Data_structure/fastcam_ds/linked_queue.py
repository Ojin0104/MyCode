class Node:
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next
 
class LinkedQueue:
    def __init__(self):
        self.front = None
        self.rear = None
 
    def is_empty(self):
        if self.front==None:
            return True
        else:
            return False
 
    def put(self, data):
        if self.front==None:##처음에 넣을때 front reat똑같은 위치설정
            self.front=Node(data,self.rear)
            self.rear=self.front
        else:
            if self.front==self.rear:#그 이후 front와 rear가 같은 것을 가리킬때 front의 next를 설정해줌 
                self.front.next=Node(data,self.rear)
            self.rear.next=Node(data,self.rear)
            self.rear=self.rear.next
        
 
    def get(self):
        if self.front==None:
            return None
        else:
            a=self.front
            self.front=self.front.next
            
        return a.data
        
 
    def peek(self):
        if self.front==None:
            return None
        return self.front.data
 
# Test code
queue = LinkedQueue()
 
print(queue.is_empty())
for i in range(10):
    queue.put(i)
print(queue.is_empty())
 
for _ in range(11):
    print(queue.get(), end=' ')
print()

 
for i in range(20):
    queue.put(i)
print(queue.is_empty())
 
for _ in range(5):
    print(queue.peek(), end=' ')
print()
 
for _ in range(21):
    print(queue.get(), end=' ')
print()
print(queue.is_empty())
 