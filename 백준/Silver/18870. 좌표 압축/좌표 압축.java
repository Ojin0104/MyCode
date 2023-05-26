import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] arr=new int[N][2];
        for(int i=0;i<N;i++){
            arr[i][0]=A[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(d1,d2)->d1[0]-d2[0]);
        int num=Integer.MIN_VALUE;
        int index=0;
        int temp=arr[0][0];
        arr[0][0]=index;
        for(int i=1;i<N ;i++){
            if(arr[i][0]>temp){
                index++;
            }
            temp=arr[i][0];
            arr[i][0]=index;

        }
        Arrays.sort(arr,(d1,d2)->d1[1]-d2[1]);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<N;i++){
            stringBuilder.append(arr[i][0]+" ");
        }
        System.out.print(stringBuilder.toString());

    }
}
