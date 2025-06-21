import java.util.*;
class Solution {
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public int solution(int[][] game_board, int[][] table) {
        //각 도형별 회전 케이스 4가지 
        // 각 빈 영역 별로 그 케이스 중 하나라도 딱 맞다면 넣는 것으로 처리
        // 사각형 영역으로 잡기
        
        boolean[][] visit = new boolean[game_board.length][game_board[0].length];
        
        List<Block> emptySpace = new ArrayList<>();
        List<Block> blockList = new ArrayList<>();
        
        for(int row = 0; row<game_board.length; row++){
            for(int col = 0; col<game_board[0].length; col++){
                if(visit[row][col] || game_board[row][col] ==1) continue;
                List<int[]> edgeList = new ArrayList<>();
                bfs(game_board, row, col, edgeList, visit,0);
                
                emptySpace.add(makeBlock(edgeList));
            }
        }
        
        
        
        visit = new boolean[table.length][table[0].length];
        for(int row = 0; row<table.length; row++){
            for(int col = 0; col<table[0].length; col++){
                if(visit[row][col] || table[row][col] ==0) continue;
                List<int[]> edgeList = new ArrayList<>();
                bfs(table, row, col, edgeList, visit,1);
                
                blockList.add(makeBlock(edgeList));
            }
        }
        
        
        
        boolean[] usedBlock = new boolean[blockList.size()];
        int answer = 0;
        for(int idx = 0; idx< emptySpace.size(); idx++){
            Block empty = emptySpace.get(idx);
            for(int seq = 0; seq<blockList.size(); seq++){
                if(usedBlock[seq])continue;
                
                if(empty.isEqual(blockList.get(seq))){
                    usedBlock[seq] = true;
                    answer += empty.size;
                    break;
                }
            }
        }
        return answer;
    }
    
    public void bfs(int[][] board, int row, int col, List<int[]> edgeList, boolean[][] visit,int status){
        
        Queue<int[]> que = new ArrayDeque<>();
        
        que.add(new int[]{row,col});
        
        while(!que.isEmpty()){
            
            int[] now = que.poll();
            
            if(visit[now[0]][now[1]]) continue;
            
            edgeList.add(now);
            visit[now[0]][now[1]] = true;
            
            for(int idx = 0 ; idx<4 ; idx++){
                int nextR = now[0] + dr[idx];
                int nextC = now[1] + dc[idx];
                
                if(nextR < 0 || nextR >= board.length ||nextC < 0 || nextC >= board[0].length)continue;
                
                if(visit[nextR][nextC]) continue;
                
                if(board[nextR][nextC] == status){
                    que.add(new int[]{nextR,nextC});
                }
            }
            
        }
    }
    
    public Block makeBlock(List<int[]> edgeList){
        int minR = 100;
        int minC = 100;
        int maxR = -100;
        int maxC = -100;
        
        for(int[] edge : edgeList){
            int row = edge[0];
            int col = edge[1];
            
            if(row<minR)minR = row;
            if(row>maxR)maxR = row;
            
            if(col<minC)minC = col;
            if(col>maxC)maxC = col;
        }
        
        int[][] map = new int[maxR-minR+1][maxC-minC+1];
        int rowFactor = -minR;
        int colFactor = -minC;
        for(int[] edge : edgeList){
            int row = edge[0] + rowFactor;
            int col = edge[1] + colFactor;
        
            map[row][col] = 1;
        }
        
        return new Block(edgeList.size(), map);
    }
    
    public boolean same(int[][] map1, int[][] map2){
        for(int row = 0; row<map1.length; row++){
            for(int col = 0; col<map1[0].length; col++){
                if(map1[row][col] != map2[row][col])return false;
            }
        }
        
        return true;
    }
    
    public int[][] rotate(int[][] map){
        int[][] newMap = new int[map[0].length][map.length];
        for(int row = 0; row<map[0].length; row++){
            for(int col = 0 ;col< map.length ;col++){
                newMap[row][col] = map[map.length-1-col][row];
            }
        }
        
        return newMap;
    }
    
    public void printMap(int[][] map){
        System.out.println();
        for(int row = 0; row<map.length; row++){
            for(int col = 0 ;col <map[0].length ; col++){
                System.out.print(map[row][col]+" ");
            }
            System.out.println();
        }
    }
    
    class Block{
        int size;
        int[][] map;
        
        public Block(int size, int[][] map){
            this.size = size;
            this.map = map;
        }
        
        public boolean isEqual(Block block){
            if(block.size != this.size)return false;
            
            //block 4방향 돌려서 비교
            int[][] newMap = block.map;
            for(int idx =0 ;idx<4; idx++){// 0 , 90, 180, 270
                 newMap = rotate(newMap);
                if(this.map.length != newMap.length || this.map[0].length != newMap[0].length)continue;
                if(same(this.map, newMap))return true;
                
                
            }
            
            return false;
            
        }
        
    }
    
}