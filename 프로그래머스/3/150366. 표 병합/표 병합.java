import java.util.*;
class Solution {
    int[] parent = new int[2500];
    String[][] cells = new String[50][50];
        
    public String[] solution(String[] commands) {
        List<String> answerList = new ArrayList<>();
        init(parent);
        for(String command: commands){
            
            String[] commandLine = command.split(" ");
            String order = commandLine[0];
            if("UPDATE".equals(order)){
                if(commandLine.length==4){
                    update(Integer.parseInt(commandLine[1])-1,Integer.parseInt(commandLine[2])-1,commandLine[3]);
                }else{
                    update(commandLine[1],commandLine[2]);
                }
            }else if("MERGE".equals(order)){
                merge(Integer.parseInt(commandLine[1])-1,Integer.parseInt(commandLine[2])-1,Integer.parseInt(commandLine[3])-1,Integer.parseInt(commandLine[4])-1);
            }else if("UNMERGE".equals(order)){
                unmerge(Integer.parseInt(commandLine[1])-1,Integer.parseInt(commandLine[2])-1);
            }else if("PRINT".equals(order)){
                answerList.add(print(Integer.parseInt(commandLine[1])-1,Integer.parseInt(commandLine[2])-1));
            }
        }
        
        String[] answer = new String[answerList.size()];
        
        for(int idx = 0 ; idx<answer.length; idx++){
            answer[idx] = answerList.get(idx);
        }
        
        return answer;
    
    }
    
    public void init(int[] parent){
        for(int idx = 0;idx<parent.length; idx++){
            parent[idx] = idx;
        }
    }
    
    public int findParent( int idx){
        if(parent[idx] == idx)return idx;
        
        return parent[idx] = findParent(parent[idx]);
    }
    
    public void update(int row, int col, String value){
        int idx = row*50 + col;
        
        int parentIdx = findParent(idx);
        
        int parentRow = parentIdx/50;
        int parentCol = parentIdx%50;
        
        cells[parentRow][parentCol] =value;
    }
    
    public void update(String value1, String value2){
        for(int row = 0 ; row< cells.length; row++){
            for(int col = 0; col<cells[0].length; col++){
                if(value1.equals(cells[row][col])){
                    cells[row][col] = value2;
                
                }
            }
        }
    }
    
    public void merge(int row1,int col1, int row2, int col2){
        int idx1 = row1*50 +col1;
        int idx2 = row2*50 + col2;
        
        idx1 = findParent(idx1);
        idx2 = findParent(idx2);
        row1 = idx1/50;
        row2 = idx2/50;
        col1 = idx1%50;
        col2 = idx2%50;
        parent[idx2] = idx1;
        
        if(cells[row1][col1] == null){
            cells[row1][col1] = cells[row2][col2];
        }
    }
    
    public void unmerge(int row, int col){
        int parentIdx = findParent(row*50+col);
        String value = cells[parentIdx/50][parentIdx%50];
        for(int idx = 0 ; idx<parent.length;idx++){
            parent[idx] = findParent(idx);
        }
        for(int idx = 0 ; idx<parent.length;idx++){
            if(parent[idx] == parentIdx){
                parent[idx] =idx;
                int nowRow = idx/50;
                int nowCol = idx%50;
                
                cells[nowRow][nowCol] = null;
            }
        }
        
        cells[row][col] = value;
    }
    
    public String print(int row,int col){
        int idx = findParent(row*50+col);
        
        int parentRow = idx/50;
        int parentCol = idx%50;
        
        if(cells[parentRow][parentCol] == null){
            
            return "EMPTY";
        }
        
        return cells[parentRow][parentCol];
    }
    
    
    
    
}