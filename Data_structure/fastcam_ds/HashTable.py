def hash_func(key):
    return ord(key[0]) % 10
 
class HashTable:
    def __init__(self):
        self.table = [None]*10
 
    def set(self, key, value):
        self.table[hash_func(key)] = value
 
    def get(self, key):
        return self.table[hash_func(key)]
 
class Node:
    def __init__(self, key, data):
        self.key = key
        self.data = data
        self.next = None
 
class ChainedHashTable(HashTable):
    def __init__(self):
          self.table = [None]*10
          
        
    def set(self,key,value):
        if self.table[hash_func(key)]!=None:
            for i in range(len(self.table[hash_func(key)])):
                if self.table[hash_func(key)][i][0]==key:#중복시 value수정
                    self.table[hash_func(key)][i][1]=value
                    return
            self.table[hash_func(key)].append([key,value])#중복아닐시 append
        else:
            self.table[hash_func(key)]=[[key,value]]
    def get(self, key):
        if self.table[hash_func(key)]==None:
            print("없습니다")
            return

        elif len(self.table[hash_func(key)])==1:
            return self.table[hash_func(key)][1]
        else:
            for i in range(len(self.table[hash_func(key)])):
                if self.table[hash_func(key)][i][0]==key:
                    return self.table[hash_func(key)][i][1]
                
            return print("없습니다.")
        
            
 
# Test code
 
ht = ChainedHashTable()
ht.set('hello', 1)
ht.set('hello2', 2)
ht.set('hello3', 3)
ht.set('hello4', 4)
 
print(ht.get('hello'), end=' ')
print(ht.get('hello2'), end=' ')
print(ht.get('hello3'), end=' ')
print(ht.get('hello4'), end=' ')
print()
 
ht.set('hello2', 5)
 
print(ht.get('hello'), end=' ')
print(ht.get('hello2'), end=' ')
print(ht.get('hello3'), end=' ')
print(ht.get('hello4'), end=' ')

