import random

class Card:
    def __init__(self,kind,number):
        self.kind=kind
        self.number=number

class Player:
    def __init__(self):
        self.cards=[]
    def printCards(self):
        for card in self.cards:
            print(card.kind+" "+str(card.number))

class Poker:
    def __init__(self,playerCnt=1,distCardCnt=5):
        self.distCardCnt=distCardCnt
        self.playerCnt=playerCnt
        self.cards=[]
        self.players=[]
        self.generateCards()
        self.shuffleCards()
        self.createPlayers()
    def generateCards(self):
        self.cards=[]
        kinds=['spade','heart','diamond','clover']

        for i in range(4):
            for j in range(13):
                card=Card(kinds[i],j+1)
                self.cards.append(card)
        
        return

    def shuffleCards(self):
        random.shuffle(self.cards)
    
    def createPlayers(self):
        for j in range(self.playerCnt):
            player=Player()
            self.players.append(player)

    def printCards(self):
        for card in self.cards:
            print(card.kind+" "+str(card.number))

    def playCards(self):
        for i in range(self.distCardCnt):
            for j in range(self.playerCnt):
                card=self.cards.pop()
                self.players[j].cards.append(card)

    def printPlayerCards(self):
        player_num=1
        for player in self.players:
            print("\nplayer",player_num,":\n")
            player.printCards()
            player_num+=1
    def countFlush(self):
        count=0
        for player in self.players:
            if(self.isFlush(player.cards)==True):
                count+=1
        return count
    def isFlush(self,targetCards):
        KindCnt={'spade':0,'heart':0,'diamond':0,'clover':0}
        for card in targetCards:
            KindCnt[card.kind]+=1
        for key in KindCnt.keys():
            if(KindCnt[key]>=5):
                return True
        return False
    
    def istwoFair(self,targetCards):
        fair_list=[0 for i in range(13)]
        fair_count=0
        for card in targetCards:
            fair_list[card.number-1]+=1
        for i in fair_list:
            if i==2:
                fair_count+=1
        if(fair_count==2):
            return True
        else:
            return False
    def counttwoFair(self):
        count=0
        for player in self.players:
            if(self.istwoFair(player.cards)==True):
                count+=1
        return count
    
playerCnt=5
distCardCnt=7
gameCnt=100000
flushCnt=0
twoFairCnt=0
for i in range(gameCnt):
    
    poker=Poker(playerCnt,distCardCnt)
    poker.playCards()
    if(poker.countFlush()>=2):##한 게임에 두번이상의 플러쉬가 나올때
        flushCnt+=1
    if(poker.counttwoFair()):
        twoFairCnt+=1

print(flushCnt)
print("플러쉬가 두개이상 나올확률: ",flushCnt/(gameCnt))
print(twoFairCnt)
print("투페어가 나올확률: ",twoFairCnt/(gameCnt))


