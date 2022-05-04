package shortesttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek11657 {
    static int N;
    static int M;
    static int C;
    static int A;
    static int B;
    static long[] result;

    static List<edge> list=new ArrayList<edge>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result=new long[N+1];

        Arrays.fill(result,Integer.MAX_VALUE); //max값으로 설정
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());//A=start,B=end,C=time
            B=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            list.add(new edge(A,B,C));
        }
        result[1]=0;//돌면서 최단경로 리셋
        result[0]=0;
        int cnt=0;
        int opt=0;
        while(cnt<N+1){//1. 전체 경로 반복 2. 해당 정점에서 연결된 간선 으로가는 게 최소인지 아니면 원래대로있는게 최소인지 3.
            cnt++;
                    for(int j=0;j<M;j++){//모든 간선확인
                        if(result[list.get(j).s]!=Integer.MAX_VALUE&&result[list.get(j).s]+list.get(j).g<result[list.get(j).t]){ //시작정점 맞다면
                            result[list.get(j).t]=result[list.get(j).s]+list.get(j).g;
                            if(cnt==N){
                                opt=1;
                            }

                        }

            }


        }







    if(opt==1){
        System.out.println(-1);
    }else {
        for (int i = 2; i < result.length; i++) {
            if(result[i]==Integer.MAX_VALUE){
                result[i]=-1;
            }
            System.out.println(result[i]);
        }
    }
    }

    static class edge{
        int s;
        int t;
        int g;
        edge(int n,int e,int g){
            this.s=n;
            this.t=e;
            this.g=g;
        }

    }
}