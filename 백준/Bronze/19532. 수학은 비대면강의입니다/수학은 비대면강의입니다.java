import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a=Integer.parseInt(stringTokenizer.nextToken());
        int b=Integer.parseInt(stringTokenizer.nextToken());
        int c=Integer.parseInt(stringTokenizer.nextToken());
        int d=Integer.parseInt(stringTokenizer.nextToken());
        int e=Integer.parseInt(stringTokenizer.nextToken());
        int f=Integer.parseInt(stringTokenizer.nextToken());

        for(int x=-999;x<=999;x++){
            for(int y=-999;y<=999;y++){
                if(a*x+b*y==c&&d*x+e*y==f){
                    System.out.println(x+" "+y);
                    return;
                }
            }
        }
    }
}
