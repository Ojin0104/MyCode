import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i]=i;
        }
        st=new StringTokenizer(br.readLine());
        int know=Integer.parseInt(st.nextToken());
        for(int i=0;i<know;i++){
            parent[Integer.parseInt(st.nextToken())]=0;
        }

        int[] party=new int[M];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int partySize=Integer.parseInt(st.nextToken());

            for(int j=0;j<partySize;j++){
                if(j==0){
                    party[i]=Integer.parseInt(st.nextToken());
                }else{
                    union(party[i],Integer.parseInt(st.nextToken()));
                }
            }

        }
        int answer=0;
        for(int par:party){
            if(find(par)!=0)answer++;
        }
        System.out.println(answer);
    }
    static boolean union(int a,int b){
        int A=find(a);
        int B=find(b);

        if(A==B)return true;

        if(A<B){
            parent[B]=A;
        }else{
            parent[A]=B;
        }
        return false;
    }

    static int find(int A){
        if(parent[A]==A)return A;

        return parent[A]=find(parent[A]);
    }
}
