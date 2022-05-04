package 위상정렬;

import java.io.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1516게임개발 {//dfs안됨 위상정렬로
    static int N;
    static int[] time;
    static ArrayList<Integer>[] tree;//위상정렬
    static ArrayList<Integer>[] need;
    static int[] sum;
    static int[] count;
    static boolean[] check;
    static ArrayDeque<Integer> que=new ArrayDeque<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int parent;
        check=new boolean[N+1];
        time = new int[N + 1];
        sum=new int[N+1];
        count=new int[N+1];
        Arrays.fill(sum,Integer.MAX_VALUE);
        tree = new ArrayList[N + 1];
        need=new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
            need[i]=new ArrayList<>();

        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                parent = Integer.parseInt(st.nextToken());

                if (parent == -1) break;
                tree[parent].add(i);

                //System.out.println(i+" "+son);
                need[i].add(parent);
                count[i]++;
            }
        }
        for(int i=1;i<N+1;i++){
            if(count[i]==0){
                sum[i]=time[i];
               que.add(i);
               check[i]=true;
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        while(que.size()!=0){
            int point=que.poll();
            for(int i=0;i<tree[point].size();i++){
                int child=tree[point].get(i);
                count[child]--;
                if(count[child]==0){
                    que.add(child);
                    int max=0;
                    for(int j=0;j<need[child].size();j++) {

                        if(max<sum[need[child].get(j)]){
                          //  System.out.println("size"+need[child].size());
                            max=sum[need[child].get(j)];

                        }

                    }
                   // System.out.println();
                    sum[child] = max + time[child];
//System.out.println(child+" "+sum[child]);
                }




//                if(allcheck){
//                    sum[child] = Math.min(sum[child], sum[point] + time[child]);
//                }
            }

        }
        for(int i=1;i<N+1;i++){
            sb.append(sum[i]+"\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
                br.close();


    }

}
