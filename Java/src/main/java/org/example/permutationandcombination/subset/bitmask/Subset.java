package org.example.permutationandcombination.subset.bitmask;

public class Subset {
    private static int[] arr = new int[] {1, 2, 3, 4};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < (1 << arr.length); i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.append(arr[j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
