import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1806 {
    static int N;
    static int M;
    static int[] num;
    public static  void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());//공백구분


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1];
        //int low = 0;
        int count=0;
        st=new StringTokenizer(br.readLine());
        //  System.out.println(N+" n "+M);
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(num));

        int low=0,high=0,sum=0,minLength=Integer.MAX_VALUE;
        sum=num[0];
        while(true){
            if(sum>=M){
                minLength=Math.min(high-low+1,minLength);
                sum-=num[low++];
            }else{
                sum+=num[++high];


            }
            if(high==N){

            break;}

        }
        if(minLength==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(minLength);
        }
//        for(int i=0;i<N;i++){//앞포인터
//
//            int sum=0;
//            for(int k=i;k<N;k++){
//
//                sum+=num[k];
//                if(sum>=M){
//                   count=k-i+1;
//                   if(low==0)low=count;
//                   if (count<low)low=count;
//                    break;
//                }
//            }
//
//
//        }
        System.out.print(low);
    }

}
