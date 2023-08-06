import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //숫자가 같으면서 서로의 거리 의 차가 움직이는 숫자로 나눠지지않으면 만날 수 업승ㅁ
        //

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine());

        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());

        int answer = findIndex(A,B,X,Y);
        System.out.println(answer);

    }

    static int findIndex(int A,int B, int X,int Y){
        int div =B;
        if(A<B)div=A;
        if(A%div==0&&B%div==0&&Math.abs(X-Y)%div!=0)return -1;
        HashMap<Integer,Boolean> check = new HashMap<>();
        while(true){
            if(check.containsKey(X)){
                return X;
            }
            if (check.containsKey(Y)) {
                return Y;
            }
            check.put(X,true);
            check.put(Y,true);
            X+=A;
            Y+=B;
            
            if(X>=10005&&Y>=10005)return -1;
        }
    }
}
