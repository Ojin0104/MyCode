import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1654랜선자르기 {
    static int n;
    static int k;
    static long[] len;
    public static void main(String args[]) throws IOException {
        //k가


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        k=Integer.parseInt(stringTokenizer.nextToken());
        n=Integer.parseInt(stringTokenizer.nextToken());
        len=new long[k];
        for(int i=0;i<k;i++){
            len[i]=Long.parseLong(bufferedReader.readLine());
        }

        System.out.println(binSearch(0,Integer.MAX_VALUE));
    }
    public static long binSearch(long left, long right){

        long mid;
        long num;

        while(left<=right){
            mid=(left+right)/2;
            num=calcNum(mid);
        if(num<n)
            right=mid-1;
        else
            left=mid+1;
        }

        return right;
    }

    public static long calcNum(long mid){
        long answer=0;
        for(int i=0;i<len.length;i++){
            answer+=len[i]/mid;
        }
        return answer;
    }
}
