class Solution {
    static int blank = 0;
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        blank = countBlank(lock);
        for(int i=0;i<4;i++){
            //4번 회전하며 케이스 확인
            //케이스확인
            //(0,0) 위치 이동
            for(int dr = -M+1; dr<N;dr++){
                for(int dc = -M+1;dc<N;dc++){
                    if(checkFit(dr,dc,key,lock))
                        return true;
                }
                
            }
            //회전
            key = rotateKey(key);
            
        }
        
        return false;
    }
    
    static int[][] rotateKey(int[][] key){
        int[][] newKey = new int[key.length][key.length];
        
        for(int r = 0;r<key.length;r++){
            for(int j=0;j<key.length;j++){
                newKey[key.length-1-j][r] = key[r][j];
            }
        }
        
        return newKey;
    }
    
    static int countBlank(int[][] lock){
        int answer = 0;
        for(int r = 0;r<lock.length;r++){
            for(int c = 0;c<lock.length;c++){
                if(lock[r][c]==0)answer++;
            }
        }
        return answer;
    }
    static boolean checkFit(int dr,int dc,int[][] key, int[][] lock){
      int count =0;
        for(int r = 0;r<key.length;r++){
            for(int c = 0;c<key.length;c++){
                if(dr+r<0||dr+r>=lock.length||dc+c<0||dc+c>=lock.length)continue;
                
                if(key[r][c]+lock[dr+r][dc+c]==0||key[r][c]+lock[dr+r][dc+c]==2)return false;
                
                if(key[r][c]==1){
                    count++;
                }
            }
        }
        if(count==blank)return true;
        
        return false;
    }
}