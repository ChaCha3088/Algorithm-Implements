package org.example.permutationandcombination.practice;

public class Combination {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr = {1, 2, 3, 4, 5};
    private static int N = 5;
    private static int K = 3;

    public static void main(String[] args) {
        for (int i = 0; i < (1 << N); i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    count += 1;
                }
            }

            if (count == K) {
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) > 0) {
                        sb.append(arr[j]).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
