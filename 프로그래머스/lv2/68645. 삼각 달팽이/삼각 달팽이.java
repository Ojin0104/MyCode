class Solution {
    static boolean[][] check;
    static int[][] arr;
    static int count=0;
    static int totalcount=0;
    public int[] solution(int n) {
        
        
        if(n==1)return new int[]{1};
        arr=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            totalcount+=(i+1);
        }
        
        check=new boolean[n+1][n+1];
        for(int i=1;i<n/2+1;i++){
            //밑으로
            godown(2*i-1,i,n);//시작(row,col)(i-1)*2+1
            goright(n-(i-1),i,n);
            goup(n-i+1,n-(i-1)*2,n);
            
            
        }
        int[] answer=new int[totalcount];
        int index=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                answer[index++]=arr[i][j];
            }
        }
        return answer;
    }
    static void godown(int row,int col,int n){
        int nextrow=row;
        for(int i=0;i<n-row-row/2;i++){
            if(check[nextrow][col]){
                nextrow++;
                continue;
            }
            if(nextrow>n)return;
           //System.out.println(nextrow+" "+col);
            count++;
            if(count>totalcount)return;
            arr[nextrow][col]=count;
            check[nextrow][col]=true;
            nextrow++;
        }
    }
    
    static void goright(int row,int col,int n){
        int nextcol=col;
        for(int i=0;i<=row-col;i++){
             if(check[row][nextcol]){
                return;
            }
            if(nextcol>row)return;
          // System.out.println(row+" "+nextcol);
            count++;
            if(count>totalcount)return;
            arr[row][nextcol]=count;
            check[row][nextcol]=true;
            nextcol++;
        }
    }
    static void goup(int row,int col,int n){
        
        int nextrow=row;
        int nextcol=col;
        //System.out.println(nextrow+" "+nextcol);
        for(int i=0;i<col-2;i++){
            
            nextrow--;
            nextcol--;
            if(check[nextrow][nextcol])return;
           // System.out.println(nextrow+" "+nextcol);
            
            count++;
            if(count>totalcount)return;
            //System.out.println(count);
            check[nextrow][nextcol]=true;
            arr[nextrow][nextcol]=count;
            
        }
    }
}