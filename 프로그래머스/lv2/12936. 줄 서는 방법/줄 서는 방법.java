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
    
    long factorial(int n){
        if(n==1)return 1;
        if(n==0)return 1;
        return factorial(n-1)*n;
    }
}