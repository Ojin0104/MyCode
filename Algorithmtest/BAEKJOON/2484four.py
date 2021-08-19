person=int(input())
max=0
for i in range(person):
    nums=list(map(int,input().split(" ")))
    nums.sort()
    if len(set(nums))==1:
        prize=50000+nums[0]*5000
    elif len(set(nums))==2:
        if nums[1]!=nums[2]:
            prize=(2000+nums[1]*500+nums[2]*500)
        else:
            prize=(10000+nums[1]*1000)
    elif len(set(nums))==3:
        for k in range(len(nums)-1):
            if nums[k]==nums[k+1]:
                prize=1000+nums[k]*100
                break
    else:
        prize=(nums[3]*100)

    if max<prize:
        max=prize
print(max)