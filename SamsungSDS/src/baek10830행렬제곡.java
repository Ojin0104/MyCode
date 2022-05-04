import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek10830행렬제곡 {
    static int N;
    static long B;
    //행렬제곱하는 함수
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
N=Integer.parseInt(stringTokenizer.nextToken());
B=Long.parseLong(stringTokenizer.nextToken());
int[][] A=new int[N][N];
    for(int i=0;i<N;i++){
        stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        for(int j=0;j<N;j++){
            A[i][j]=Integer.parseInt(stringTokenizer.nextToken())%1000;
        }

    }
    //여기서 차수 계산해서 while 문으로 *2하거나 아니면 이진법
        //B==1이면 A바로출력
    int[][] K=square(A,B);
        for(int i=0;i<N;i++){
             for(int j=0;j<N;j++){
                System.out.print(K[i][j]+" ");
             }
             System.out.println();

        }

    }
    static int[][] square(int[][]A,long b){
        if(b==1){
            return A;

        }
        else if(b%2==0){
            int[][] A2=square(A,b/2);
            return mulmat(A2,A2);
        }else{
            return mulmat(square(A,b-1 ),A);
        }
    }
    static int[][] mulmat(int [][]A,int [][]A2){
        int size=A.length;
        int[][] C=new int[size][size];
        int sum=0;
        for(int i=0;i<size;i++){//행

            for(int j=0;j<size;j++){//열
                sum=0;
                for(int k=0;k<size;k++){
                    sum+=A[i][k]*A2[k][j];
                }

                C[i][j]=sum%1000;
            }


        }
        return C;
    }
}
