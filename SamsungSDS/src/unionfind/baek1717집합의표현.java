package unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class baek1717집합의표현 {
    static int N;
    static int M;
    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        int a;
        int b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {//합치기
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {//부모 같은지확인
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
               if( check(a, b)) {
                   sb.append("YES\n");
               }
                   else{
                   sb.append("NO\n");
                   }
               }
            }
        bw.write(String.valueOf(sb));
bw.flush();

        }


    static int parents(int a) {
        if (parent[a] == a) {
            return a;

        } else {
            return parent[a]=parents(parent[a]);
        }
    }

    static boolean check(int a, int b) {
        if (parents(a) == parents(b)) return true;
        return false;
    }

    static void union(int a, int b) {
        if (check(a, b)) return;
        else {
            parent[parents(a)] = parents(b);

        }
    }
}
