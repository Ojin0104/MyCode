import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long num=Integer.MAX_VALUE*3L;
    static long[] answer=new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long[] arr=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(stringTokenizer.nextToken());

        }
        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                binSearch(i,j,arr);
            }
        }
        Arrays.sort(answer);

        for(int i=0;i<3;i++){
            System.out.print(answer[i]+" ");
        }




    }
    static void binSearch(int first,int second,long[] arr){
        int left=0;
        int right=arr.length-1;
        long find=-1*(arr[first]+arr[second]);

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]<find){
                left=mid+1;

            }else if(arr[mid]>find){
                right=mid-1;

            }else{
                break;
            }
        }

        long rightnum=0;
        long leftnum=0;
        for(int i=0;i<2;i++) {
            if (left == first || left == second) {
                left++;
            }

            if (right == first || right == second) {
                right--;
            }
        }
        if(right>=0&&right<arr.length){
            rightnum=arr[right];
            if(Math.abs(find-rightnum)<num){
                num=Math.abs(find-rightnum);
                answer[0]=arr[first];
                answer[1]= arr[second];
                answer[2]= rightnum;
            }
        }
        if(left>=0&&left<arr.length){
            leftnum=arr[left];
            if(Math.abs(find-leftnum)<num){
                num=Math.abs(find-leftnum);
                answer[0]=arr[first];
                answer[1]=arr[second];
                answer[2]=leftnum;
            }
        }


    }
}
