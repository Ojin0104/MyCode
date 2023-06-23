import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static int V;
    static int E;

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        int[][] map=new int[V+1][V+1];
        for(int i=0;i<V+1;i++){
            Arrays.fill(map[i],10000000);
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<V+1;i++){
            for(int j=1;j<V+1;j++){
                for(int k=1;k<V+1;k++){
                    if(map[j][k]>map[j][i]+map[i][k]){
                        map[j][k]=map[j][i]+map[i][k];

                    }
                }
            }
        }
        int min=10000000;
        for(int i=1;i<V+1;i++) {

                if(map[i][i]<min)
                    min=map[i][i];



        }
        if(min!=10000000)
            System.out.println(min);
        else
            System.out.println(-1);




    }
}
