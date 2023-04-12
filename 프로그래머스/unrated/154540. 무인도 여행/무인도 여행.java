import java.util.*;
class Solution {
    static ArrayList<Integer> island_bob;
    static char[][] copy_maps;
    static int[] dx={0,-1,0,1};
    static int[] dy={1,0,-1,0};
    public int[] solution(String[] maps) {
        island_bob=new ArrayList<>();
        copy_maps=new char[maps.length][maps[0].length()];
        
         for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                copy_maps[i][j]=maps[i].charAt(j);
            }
         }
        
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                //1~9사이 자연수일경우
                if(copy_maps[i][j]!='X'&&copy_maps[i][j]!='0'){
                    island_bob.add(0);
                    //System.out.println(copy_maps[i][j]);
                    bfs(i,j);
                }
                
            }
        }
        System.out.println(island_bob.size());
        int[] answer=new int[island_bob.size()];
        Collections.sort(island_bob);
                         
        for(int i=0;i<island_bob.size();i++){
            answer[i]=island_bob.get(i);
        }
        
        if(island_bob.size()==0)
            answer=new int[]{-1};
        return answer;
    }
    static void bfs(int i,int j){
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{i,j});
        
        int answer=Character.getNumericValue(copy_maps[i][j]);
         copy_maps[i][j]='0';
        while(!que.isEmpty()){
            int[] now=que.poll();
            for(int k=0;k<4;k++){
                int nx=now[0]+dx[k];
                int ny=now[1]+dy[k];
                
                if(nx<0||ny<0||nx>=copy_maps.length||ny>=copy_maps[0].length)continue;
                
                if(copy_maps[nx][ny]=='0'||copy_maps[nx][ny]=='X')continue;
              //  System.out.println(answer);
                //System.out.println(copy_maps[nx][ny]);
                answer+=Character.getNumericValue(copy_maps[nx][ny]);
                copy_maps[nx][ny]='0';
                que.add(new int[]{nx,ny});
                
            }
            
        }
        island_bob.set(island_bob.size()-1,answer);
        
    }
}