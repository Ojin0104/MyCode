import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] adjacencyMatrix = new long[8][8];
        long[][] now =  {
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0}
        };

        for(int i = 0 ;i<8;i++){
            adjacencyMatrix[i][i] =1;
        }
        while(N>0){
            if(N%2==1){
                adjacencyMatrix = multi(adjacencyMatrix,now);
                N-=1;

            }
            now= multi(now,now);
            N/=2;
        }

        System.out.println(adjacencyMatrix[0][0]);
    }



    static long[][] multi(long[][] mat1,long[][] mat2){
        long[][] squaredMatrix = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                long num = 0;
                for (int k = 0; k < 8; k++) {
                    num += (mat1[i][k] * mat2[k][j])%1000000007;
                    num %= 1000000007;
                }

                squaredMatrix[i][j] = num%1000000007;
            }
        }
        return squaredMatrix;
    }
}
