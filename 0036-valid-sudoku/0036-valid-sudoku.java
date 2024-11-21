import java.util.*;
class Solution {
    static HashMap<Character,Boolean>[] rowMap = new HashMap[9];
    static HashMap<Character,Boolean>[] colMap = new HashMap[9];
    static HashMap<Character,Boolean>[] matMap = new HashMap[9];
    public boolean isValidSudoku(char[][] board) {
        for(int idx = 0 ;idx<9;idx++){
            rowMap[idx] = new HashMap<Character,Boolean>();
            colMap[idx] = new HashMap<Character,Boolean>();
            matMap[idx] = new HashMap<Character,Boolean>();
        }


        for(int row = 0; row<9; row++){
            for(int col = 0; col<9; col++){
                    if(board[row][col]!='.'){
                        Character now = board[row][col];
                        if(rowMap[row].containsKey(now) || colMap[col].containsKey(now) || matMap[(row/3)*3+col/3].containsKey(now))return false;
                        rowMap[row].put(now,true);
                        colMap[col].put(now,true);
                        matMap[(row/3)*3+col/3].put(now,true);
                    }
            }
        }

        return true;

    }

    
}