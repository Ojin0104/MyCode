import java.util.*;
public class Main {
    static int mod = 1000000000;
    static int[][][] dp = new int[101][10][1 << 10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int temp = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][1][k]) % mod;
                    } else if (j == 9) {
                        dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][8][k]) % mod;
                    } else {
                        dp[i][j][temp] = ((dp[i][j][temp] + dp[i - 1][j - 1][k]) % mod + dp[i - 1][j + 1][k]) % mod;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i][(1 << 10) - 1]) % mod;
        }

        System.out.println(answer);
    }
}