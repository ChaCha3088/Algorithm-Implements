package org.example.permutationandcombination.practice;

public class Subset {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr = {1, 2, 3, 4, 5};
    private static int N = 5;

    public static void main(String[] args) {
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.append(arr[j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
