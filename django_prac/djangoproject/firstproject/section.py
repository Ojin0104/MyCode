import datetime
import sqlite3
#db생성
conn=sqlite3.connect('C:/users/hanyj/database.db',isolation_level=None)
#cursor
c=conn.cursor()
print('Cursor Type: ',type(c))
#테이블생성(data type:TEXT,NUMERIC INTEGER REAL BLOB)
c.execute("CREATE TABLE IF NOT EXISTS users(id INTIGER PRIMARY KEY,username text,email text)")
c.execute("INSERT INTO users VALUES(1,'Kim','kim@naver.com')")##변수로넣으려면 VALUES(1,?)",(변수))

#many 삽입
userList=(
    (1,'kim','han@naver.com'),
    (2,'lee','lee@naver.com')
)
c.executemany("INSERT INTO users(id,username,email)\
    VALUES(?,?,?)",userList)
#테이블 삭제
print(conn.execute("DELETE FROM users").rowcount)#삭제후 몇줄삭제했느지도 말해줌
conn.commit()#커밋 isolation_level=0해놓으면 자동커밋
conn.rollback()#취소

c.fetchone()# 한줄가져옴 가져오면 커서인c가이동한다 라고생각
c.fetchmany(size=3) #3줄가져옴
c.fetchall()#다
#조건조회
c.execute('select * from users where id=:Id',{"Id":5})#id가 5인 값 줄력
param4=(3,5)
c.execute("select * from users where id IN(?,?)",param4)#3,5 출력)

#dump출력
with conn:
    with open('C:~.sql','w') as f:
        for line in conn.iterdump():
            f.write('%s\n' % line)
        print('Dump Print Complete')
        