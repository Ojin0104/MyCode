import re
# "ABC" ["12:00,12:06,HELLO,ABC#ABC#ABC"] "(None)"
# "ABC" ["12:00,12:10,HELLO,ABC#ABC#ABC"] "HELLO"
# "ABC" ["12:04,13:00,HELLO,ABC#ABC#ABC"] "HELLO"
# "C#C" ["12:00,12:06,HELLO,C#C#CC#"] "HELLO"
m="ABC"
musicinfos=  ["12:04,13:00,HELLO,ABC#ABC#ABC","12:04,13:00,HELLO,XBX#ABC#ABC","12:00,12:06,HELLO,C#C#CC#","12:04,13:00,HELLO,ABX#ABC#ABC"]
def solution(m, musicinfos):
    answer = '(None)'
    musictime=[]
    
    for musicstr in musicinfos:
        music=musicstr.split(",")
   
        start=music[0].split(":")
    
        
        end=music[1].split(":")
        
        time=(int(end[0])-int(start[0]))*60+int(end[1])-int(start[1])+1
        
        if time<len(music[3]):
            music[3]=music[3][0:time]
          
        
        musictime.append([time,music[2],music[3]])
    musictime.sort(key=lambda x:(-x[0]))
    print(musictime)
    for music in musictime:
        # if music[0]<=mintime:
        #     continue
        
        if isRight(music,m):
            
            answer=music[1]
            
            break
    print(answer)
    return answer

def isRight(music,m):
    if len(m)<2*len(music[2]):
        text=2*music[2]
    else:
        text=music[2]*(len(m)//len(music[2])+1)
    index=-1
    while True:
        index=text.find(m,index+1)
        if index==-1:
            break
        print(index)
        if len(text)<=index+len(m):
            return True
        print(text[index+len(m)])
        if text[index+len(m)]!='#':
            
            return True
    return False

solution(m,musicinfos)