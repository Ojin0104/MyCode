import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        int M=Integer.parseInt(bufferedReader.readLine());
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<M;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a=Integer.parseInt(stringTokenizer.nextToken());
            int b=Integer.parseInt(stringTokenizer.nextToken());
            union(a,b);
        }

        int p=find(1);
        int count=0;

        for(int i=2;i<=N;i++){
            if(find(i)==p)count++;
        }
        System.out.println(count);


    }
    static int find(int a){
        if(parent[a]==a)return a;

        return parent[a]=find(parent[a]);
    }

    static boolean union(int a,int b){
        int A=find(a);
        int B=find(b);

        if(A==B)return false;

        if(A>B){
            parent[A]=B;
        }else{
            parent[B]=A;
        }
        return true;
    }
}
