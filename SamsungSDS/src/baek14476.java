import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14476 {
    static int N;
    static int[] nums;
    static int result;
    static int remove;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        nums=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int max=-1;
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        // 입력완료
        //공약수 함수 gcd만들기
        //왼쪽에서 오른쪽 범위 수들 최대공약수하나 반대 하나

        int[] gcdLR=new int[N];
        int[] gcdRL=new int[N];
        gcdLR[0]=nums[0];
        gcdRL[N-1]=nums[N-1];
        for(int i=1;i<N;i++){
            gcdLR[i]=gcd(gcdLR[i-1],nums[i]);
           }

        for(int i=N-2;i>=0;i--){

                gcdRL[i]=gcd(gcdRL[i+1],nums[i]);

           // System.out.println(gcdRL[i]);
        }
        for(int i=0;i<N;i++){
            System.out.print(gcdLR[i]);
        }
        for(int i=0;i<N;i++){
            System.out.print(gcdRL[i]);
        }

        for(int k=0;k<N;k++){
            if(k==0)result=gcdRL[1];
            else if(k==N-1)result=gcdLR[N-2];
            else {
                result = gcd(gcdLR[k - 1], gcdRL[k + 1]);
            }
////////////gcdLR RL세팅 완료


            if(nums[k]%result!=0){//약수없음 -> 해당
                if(max<result) {
                    max = result;
                    remove=nums[k];

                }
            }else{
                continue;
            }



            }
if(max<=1){
        System.out.println(-1);}
else{
    System.out.println(max+" "+remove);
}
        }
        //K위치에따라 if k가 3이라면 1~2 최대공약수와 4~max최대공약수  구하고
        //좌우의 최대공약수 구한뒤 K의 약수가 되는지 확인 K>result이거나 gcd(k,result)=-1 이면 약수안됨


    static int gcd(int a, int b){
        while(b!=0){//
            int r=a%b;
            a=b;
            b=r;
//System.out.println("gcd");
        }

        return a;
    }
}
