package 조합론;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek1722 {
    static int N;
    static long k;
    static long kst;
    static long[] nums;
    static List<Long> result=new ArrayList<>();
    static List<Long> check=new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            check.add((long)i);
        }
        /////////순열을 구함 순열은 nPr=n!/(n-r)! 순열의 총 갯수는 n! 이되고 각 문자의 갯수  첫번째 문자 확률은 각각  n-1!  두번쨰는 n-2! ~~ 1 까지
        if(Integer.parseInt(st.nextToken())==1){
            k=Long.parseLong(st.nextToken());
            for(int i=0;i<N;i++){
                check.add((long)i);
            }
            findcomb(N,k);
            for(int i=0;i<N;i++){
                System.out.print(result.get(i)+" ");
            }
        }else{
            nums=new long[N];
            for(int i=0;i<N;i++){
                nums[i]=Integer.parseInt(st.nextToken());
            }
            System.out.println(findst(N)+1);
        }
    }
    static void findcomb(int n,long k){//n은 남은 문자열 갯수 k는 몇번째인지
        if(n==0)return;//갯수 끝날때 종료
        long factnum=factorial(n-1);
        for(int i=0;i<n;i++){
        if(k<=factnum){
            result.add(check.get(i)+1);
            check.remove(i);
            findcomb(n-1,k);//
            break;
        }else{
        k-=factnum;
            }
        }
    }
    static long findst(int n){

        if(n==0)return 0;
        long factnum=factorial(n-1);
        for(int i=0;i<n;i++){
            if((check.get(i)+1)==nums[N-n]){//같을때 factnum*i만큼 번쨰에 위치하게됨
//System.out.println("i"+ i);
                check.remove(i);
                kst+=factnum*i+findst(n-1);
       //         System.out.println(kst+1);
                break;
            }
        }
        return kst;
    }

    static long factorial(int n){
        if(n==1||n==0)
            return 1;

        return factorial(n-1)*n;
    }
}
