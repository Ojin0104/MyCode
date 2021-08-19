nums=list(map(int,input().split(" ")))
nums.sort()
if len(set(nums))==1:
    print(10000+nums[0]*1000)
elif len(set(nums))==2:
    print(1000+nums[1]*100)
else:
    print(nums[2]*100)