package org.example.permutationandcombination.combination.dp;

import java.io.IOException;

public class CombinationWithDP {
    private static int N;
    private static int R;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        N = 29;
        R = 13;
        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        int result = combinate(N, R);

        System.out.println(result);
    }

    private static int combinate(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            return dp[n][r];
        }

        return dp[n][r] = combinate(n - 1, r - 1) + combinate(n - 1, r);
    }
}
