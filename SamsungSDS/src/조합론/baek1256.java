package 조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1256 {
    static int N;
    static int M;
    static int K;
    static int[][] pascal;
    static String result="";
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        pascal=new int[M+N+1][M+N+1];

        makepascal(M+N+1);

        for(int i=0; i<M+N+1;i++){
            for(int j=0;j<M+N+1;j++){
                System.out.print(pascal[i][j]);
            }
            System.out.println();
        }
        System.out.println(pascal[M+N][M+1]);
        if(K>pascal[M+N][M]){
            System.out.println(-1);
        }else{
            query(N,M,K,result);
        }
        ///M+N,M>K이면 b로 가주

    }

    static int combination(int n, int r){
        if(n==r||r==0){
            return 1;
        }else if(pascal[n][r]!=0){
            return pascal[n][r];
        }else{
            return pascal[n][r]=Math.min((int)1e9,combination(n-1,r-1)+combination(n-1,r));
        }//어차피 k는 최대 10억이므로 최대값 지정해줌
    }
    static void makepascal(int size){
    for(int i=0;i<size;i++){

        for(int j=0;j<=i;j++){
            if(j==0||j==i)pascal[i][j]=1;
            else{
            pascal[i][j]=Math.min((int)1e9,pascal[i-1][j-1]+pascal[i-1][j]);}
        }
    }
    }
    static void query(int n,int m, int k, String s) {
        if ((n + m) == 0) {
            //n+m==0인 경우 끝났으므로
            System.out.println(s);
        } else if (n == 0) {
            //a 다썼으므로 s에 z추가하고 m-1쿼ㅣ실행
            s += "z";
            query(n, m - 1, k, s);
        } else if (m == 0) {
            s += "a";
            query(n - 1, m, k, s);
        } else {
            if (pascal[m + n-1][m] >= k) {//a에속함
                s += "a";
                query(n - 1, m, k, s);
            } else {
                s += "z";
                k -= pascal[m + n-1][m];
                query(n, m - 1, k, s);
            }
        }

    }


}
