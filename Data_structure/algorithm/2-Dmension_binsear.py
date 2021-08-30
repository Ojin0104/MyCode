matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13

def searchMatrix(matrix, target):
  rl=len(matrix)
  cl=len(matrix[0])
  if rl==0 and cl==0 :
    return False
  start=0
  end=rl*cl-1
  while(start<=end):
    mid=(start+end)//2
    rmid=mid//cl
    cmid=mid%cl
    if matrix[rmid][cmid]==target:
      return True
    elif matrix[rmid][cmid]>target:
      end=mid-1
    else:
      start=mid+1
  return False
print(searchMatrix(matrix, target))      
print('hello'*3)

str="helhel"
a="hel"
if a*2==str:
  print('right')
print(str[0:3])
##정석답에선 열과 행을 분리해서 행 구한 후 열구하는식으로

