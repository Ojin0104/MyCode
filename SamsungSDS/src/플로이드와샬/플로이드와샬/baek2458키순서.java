package 플로이드와샬;



import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2458키순서 {//정확히 모르는경우 같은 부모인데 자식이 다른경우

    static int[][] tree;
    static int[] count;//count가 0이면 큐에 넣음
    static ArrayDeque<Integer> que= new ArrayDeque<>();
    static int N;
    static int M;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tree=new int[N+1][N+1];
        count=new int[N+1];

        for(int i=1;i<N+1;i++){
            Arrays.fill(tree[i],600);
            tree[i][i]=0;
        }

        int man;
        int taller;
        for(int i=0;i<M;i++){//키 넣어줌
            st=new StringTokenizer(br.readLine());
            man=Integer.parseInt(st.nextToken());
            taller=Integer.parseInt(st.nextToken());
            tree[man][taller]=1;
        }

        for(int i=1;i<N+1;i++){//각노드별
            for(int j=1;j<N+1;j++){
                for(int k=1;k<N+1;k++){
                    tree[j][k]=Math.min(tree[j][k],tree[j][i]+tree[i][k]);
                }
            }
        }

        int sum=0;
        int cnt=0;


        for(int i=1;i<N+1;i++){
            cnt=1;
            for(int j=1;j<N+1;j++){//서로 경로가 하나라도 없는 두 정점 = 순서를 알수 없다.
                if(tree[i][j]==600&&tree[j][i]==600){
                    cnt=0;
                    System.out.println(i+" "+j);
                    break;
                }
            }
            sum+=cnt;         }

        System.out.println(sum);
        br.close();
    }
}
