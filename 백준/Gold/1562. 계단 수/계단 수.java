import java.util.Scanner;

public class Main {
    static int mod = 1000000000;
    static int N;
    static Integer[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Integer[N + 1][10][1 << 10];
        int result = 0;

        for (int i = 1; i <= 9; i++) {
            result = (result + find(N, i, 1 << i)) % mod;
        }

        System.out.println(result);
    }

    static int find(int digit, int num, int bit) {
        if (digit == 1) {
            if (bit == (1 << 10) - 1) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[digit][num][bit] != null) {
            return dp[digit][num][bit];
        }

        int tmp = 0;

        if (num - 1 >= 0) {
            tmp = (tmp + find(digit - 1, num - 1, bit | 1 << (num - 1))) % mod;
        }

        if (num + 1 <= 9) {
            tmp = (tmp + find(digit - 1, num + 1, bit | 1 << (num + 1))) % mod;
        }

        return dp[digit][num][bit] = tmp;
    }
}