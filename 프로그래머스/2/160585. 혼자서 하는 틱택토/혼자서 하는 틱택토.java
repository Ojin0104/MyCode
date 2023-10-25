import java.util.*;
class Solution {
    public int solution(String[] board) {
        //X가 많거나 O가 X보다 두개이상 많은 상황
        //빙고가 두개인상황
        boolean Obingo=false;
        boolean Xbingo=false;
        int xcount=0;
        int ocount=0;
        for(int i=0;i<3;i++){
            for( int j=0;j<3;j++){
                if(board[i].charAt(j)=='O')ocount++;
                if(board[i].charAt(j)=='X')xcount++;
                if(i==0&&board[i].charAt(j)!='.'){
                    if(board[1].charAt(j)==board[0].charAt(j)&&board[2].charAt(j)==board[0].charAt(j)){
                        if(board[1].charAt(j)=='O')Obingo=true;
                        else
                            Xbingo=true;
                        
                    }
                }
                    if(j==0&&board[i].charAt(j)!='.'){
                    if(board[i].charAt(0)==board[i].charAt(1)&&board[i].charAt(2)==board[i].charAt(0)){
                        if(board[i].charAt(0)=='O')Obingo=true;
                        else
                            Xbingo=true;
                    }
                        
                    if(i==0&&j==0&&board[i].charAt(j)!='.'){
                        if(board[i].charAt(0)==board[1].charAt(1)&&board[2].charAt(2)==board[i].charAt(0)){
                        if(board[i].charAt(0)=='O')Obingo=true;
                            else
                                Xbingo=true;
                    }
                    }
                    if(i==2&&j==0&&board[i].charAt(j)!='.'){
                        if(board[i].charAt(0)==board[1].charAt(1)&&board[0].charAt(2)==board[i].charAt(0)){
                        if(board[i].charAt(0)=='O')Obingo=true;
                            else
                                Xbingo=true;
                    }
                    }
                        
                        
                }
            }
        }
        if(Obingo&&Xbingo)return 0;
        if(xcount>ocount||ocount-xcount>=2)return 0;
        if(Xbingo&&!Obingo&&ocount!=xcount)return 0;
        if(Obingo&&!Xbingo&&ocount==xcount)return 0;
        return 1;
    }
}