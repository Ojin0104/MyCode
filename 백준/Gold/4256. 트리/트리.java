import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] pre;
    static int[] in;
    static int N;
    static StringBuilder stringBuilder =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<T;i++){
            N=Integer.parseInt(bufferedReader.readLine());
            pre = new int[N];
            in = new int[N];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                pre[j]=Integer.parseInt(stringTokenizer.nextToken());

            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                in[j]=Integer.parseInt(stringTokenizer.nextToken());

            }

            dfs(0,0,N);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void dfs(int root ,int start,int end){
        if(root>=N)return;
        int rootIndex = findRoot(pre[root],start,end);//in에서 pre의 위치를찾음
        if(rootIndex==-1)return;
        dfs(root+1,start,rootIndex);
        dfs(root-start+rootIndex+1,rootIndex+1,end);
        stringBuilder.append(in[rootIndex]+" ");
    }

    static int findRoot(int find,int start, int end){
        for(int i = start;i<end;i++){
            if(in[i]==find){
                return i;
            }
        }
        return -1;
    }

}