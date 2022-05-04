package 조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14889스타트와링크 {
    static int N;
    static int[][] point;
    static int min=Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        point=new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){

                point[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        boolean[] A=new boolean[N+1];
        dfs(0,0,A);
        System.out.println(min);
    }
    static void dfs(int order,int n,boolean[] visit){
        if(n==N/2){
            min=Math.min(sums(visit),min);
        }
        if(order>=N)return;
        order++;
        boolean[] visit2=visit.clone();
        dfs(order,n,visit);
        n++;
        visit2[order]=true;
        dfs(order,n,visit2);
    }
    static int sums(boolean[]visit){
//        for(int i=1;i<visit.length;i++){
//            System.out.print(visit[i]);
//        }
//        System.out.println();
        int start=0;
        int link=0;
        for(int i=1;i<N+1;i++){
            for(int j=i+1;j<N+1;j++){
                if(visit[i]&&visit[j]){
                    start+=point[i][j]+point[j][i];
                }else if(!visit[i]&&!visit[j]){
                    link+=point[i][j]+point[j][i];
                }
            }
        }
       // System.out.println(start+" "+link);

        return Math.abs(start-link);
    }
}
//public class Main {
//
//    static int[] team1;
//    static int[] team2;
//    static int n, result = Integer.MAX_VALUE;
//
//    static void teams() {
//        int cnt = 0;
//        for(int i = 0 ; i < n ; i++) {
//            boolean is = true;
//            for(int j = 0 ; j < team1.length ; j++) {
//                if(i == team1[j]) {
//                    is = false;
//                    break;
//                }
//            }
//
//            if(is) {
//                team2[cnt++] = i;
//            }
//        }
//    }
//    static void dfs(int idx, int start, int[][] s) {
//        if(idx == n/2) {
//            int sum1 = 0;
//            for(int i = 0 ; i < team1.length ; i++) {
//                for(int j = i ; j < team1.length ; j++) {
//                    if(i == j) {
//                        continue;
//                    }
//                    sum1 += s[team1[i]][team1[j]] + s[team1[j]][team1[i]];
//                }
//            }
//
//            teams();
//
//            int sum2 = 0;
//            for(int i = 0 ; i < team2.length ; i++) {
//                for(int j = i ; j < team2.length ; j++) {
//                    if(i == j) {
//                        continue;
//                    }
//                    sum2 += s[team2[i]][team2[j]] + s[team2[j]][team2[i]];
//                }
//            }
//
//            int max = Math.max(sum1, sum2);
//            int min = Math.min(sum1, sum2);
//
//            result = Math.min(result, max-min);
//            return;
//        }
//
//        for(int i = start ; i < n ; i++) {
//            team1[idx] = i;
//            dfs(idx+1, i+1, s);
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//
//        int[][] s = new int[n][n];
//        for(int i = 0 ; i < n ; i++) {
//            String[] arr =  br.readLine().split(" ");
//            for(int j = 0 ; j < n ; j++) {
//                s[i][j] = Integer.parseInt(arr[j]);
//                if(i == j) {
//                    s[i][j] = 0;
//                }
//            }
//        }
//
//        team1 = new int[n/2];
//        team2 = new int[n/2];
//        dfs(0, 0, s);
//
//
//        System.out.print(result);
//    }
//}