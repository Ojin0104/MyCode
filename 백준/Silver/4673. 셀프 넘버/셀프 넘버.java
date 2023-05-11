import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] nums=new boolean[10001];
        int self=0;
        for(int i=0;i<=10000;i++) {
            self=selfNum(i);
            if(self<=10000) {
                nums[selfNum(i)] = true;
            }
        }

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<=10000;i++){
            if(!nums[i]){
                bw.write(i+"");
                bw.newLine();
            }
        }
        bw.flush();
    }
    static int selfNum(int n){
        int sum=n;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
