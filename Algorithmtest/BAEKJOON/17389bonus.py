cycle=int(input())
correct=input()
bonus=0
score=0
for i in range(cycle):
    if correct[i]=='O':
        score+=i+bonus+1
        bonus+=1

    elif correct[i]=='X':
        bonus=0
    else:
        print("잘못된 입력")
print(score)
