import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek20922겹치는건싫어 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N=Integer.parseInt(stringTokenizer.nextToken());
        int K=Integer.parseInt(stringTokenizer.nextToken());

        int[] nums=new int[100001];
        int[] arr=new int[N+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int left=0;
        int length=0;
        int answer=0;
        for(int i=0;i<N;i++){//i는 right 포인터

            nums[arr[i]]++;
            if(nums[arr[i]]>K){
                int j=left;
                answer=Math.max(answer,i-left);
                while(arr[j]!=arr[i]){

                    nums[arr[j]]--;
                    j++;

                }
                nums[arr[j]]--;
                left=j+1;


            }
        }
        answer=Math.max(answer,N-left);
        System.out.println(answer);


    }
}
