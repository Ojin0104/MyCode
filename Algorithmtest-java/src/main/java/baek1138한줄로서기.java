import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1138한줄로서기 {

    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());

        int[] height = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int cansee;
        for (int i = 0; i < n; i++) {
            cansee = Integer.parseInt(stringTokenizer.nextToken());
            int count = 0;
            int k = 0;

            while (true) {
                if (count == cansee) {
                    if (height[k] == 0) {
                        height[k] = i + 1;
                        break;
                    } else {
                        k++;
                    }
                } else {
                    if (height[k] == 0) {
                        count++;
                    }
                    k++;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(height[i]+" ");
        }
    }
}
