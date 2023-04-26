class Solution {
    static boolean[] check;
    static long count=0;
    static int[] answer;
    static boolean fin=false;
    public int[] solution(int n, long k) {
        answer = new int[n];
        check=new boolean[n+1];
        int checkcount=0;
        long factnum=0;
        for(int i=0;i<n;i++){//몇번째값
            checkcount=0;
            factnum=factorial(n-1-i);
            for(int j=1;j<n+1;j++){
                if(check[j]){
                    checkcount++;
                    continue;
                }
              
                if(k<=factnum*(j-checkcount)){
                    check[j]=true;
                    answer[i]=j;
                    k-=factnum*(j-1-checkcount);
                    break;
                }
                
            }
            
        }
        return answer;
    }
    
//     void dfs(int now,int end,long find){
//         if(now==end){
            
            

//             return;
//         }
//         if(fin)return;
        
//         for(int i=1;i<end+1;i++){
//             //System.out.println(find+" "+factorial(end-now-1)*i+" "+factorial(end-now-1)*(i-1));
            
//             if(find>factorial(end-now-1)*i||find<factorial(end-now-1)*(i-1))continue;
//           // System.out.println(find+" "+factorial(end-now-1)*i);
//             if(check[i])continue;
            
//             check[i]=true;
//             answer[now]=i;
//             dfs(now+1,end,find-factorial(end-now-1)*(i-1));
            
            
//             return;
//         }
//     }
    long factorial(int n){
        if(n==1)return 1;
        if(n==0)return 1;
        return factorial(n-1)*n;
    }
}