
a=[1,2,3,8,5,6,7,8]
ascending=True
descending=True
b=[0,0]
for i in range(len(a)):
  if i==0:
    continue
  if a[i]>a[i-1]:
    descending=False
  elif a[i]<a[i-1]:
    ascending=False
  

if ascending:
  print("ascending")
elif descending:
  print("descending")
else:
  print("mixed")

