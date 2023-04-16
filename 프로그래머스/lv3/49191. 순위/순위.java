import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd=new int[n+1][n+1];
        for(int i=0;i<floyd.length;i++){
        Arrays.fill(floyd[i],1000);
        }
        for(int[] result:results){
            floyd[result[0]][result[1]]=1;
            floyd[result[1]][result[0]]=-1;
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j)floyd[i][j]=0;
                    if(floyd[i][j]==1&&floyd[j][k]==1)
                    {
                        floyd[i][k]=1;
                        floyd[k][i]=-1;
                    }
                    
                    if(floyd[i][j]==-1&&floyd[j][k]==-1)
                    {
                        floyd[i][k]=-1;
                        floyd[k][i]=1;
                    }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(floyd[i][j]==1000){
                    answer++;
                    break;
                }
            }
        }
        return n-answer;
    }
}