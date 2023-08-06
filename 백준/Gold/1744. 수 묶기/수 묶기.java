import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        //정렬후 높은거 끼리 묶고 0은 묶지 않는다.
        //음수는 음수끼리
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());

        int[] nums = new int[N];

        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(nums);

        int sum =0;
        int index =0;
        //음수 끼리 곱하기 음수는 0이랑 곱해도됨
        while(index<N-1){
            if(nums[index]<=0&&nums[index+1]<=0){
                sum+=nums[index]*nums[index+1];
                index+=2;

            }else{
                if(nums[index]<=0){
                    sum+=nums[index];
                    index+=1;
                }
                break;
            }
        }
        //뒤에서 index까지 곱해줌
        for(int i=N-1;i>=index;i--){
            if(i==index){
                sum+=nums[i];
            }else{
                if(nums[i]!=1&&nums[i-1]!=1){
                    sum+=nums[i]*nums[i-1];
                    i--;
                }else{
                    sum+=nums[i];
                }
            }
        }

        System.out.println(sum);


    }
}
