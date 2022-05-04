import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class baek2003 {
    static int N;
    static int M;
    static int[] num;
    public static  void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());//공백구분


        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[N];
        int count=0;

        //int[] num = Integer.parseInt(br.readLine().split(" "));
        st=new StringTokenizer(br.readLine());
      //  System.out.println(N+" n "+M);
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
   // System.out.println(Arrays.toString(num));

        for(int i=0;i<N;i++){//앞포인터

                int sum=0;
                for(int k=i;k<N;k++){

                    sum+=num[k];
                    if(sum>=M){
                        if(sum==M)count+=1;
                        break;
                    }
                    }


                }

        System.out.println(count);
        }

    }


