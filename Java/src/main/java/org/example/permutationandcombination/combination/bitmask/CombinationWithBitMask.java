package org.example.permutationandcombination.combination.bitmask;

public class CombinationWithBitMask {
    private static int[] arr = new int[] {1, 2, 3, 4};
    private static int K = 3;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < (1 << arr.length); i++) {
            // 개수 세기
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    count += 1;
                }
            }

            // 개수가 딱 K이면
            if (count == K) {
                for (int j = 0; j < arr.length; j++) {
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
