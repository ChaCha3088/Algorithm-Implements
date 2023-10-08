package org.example.bitmask;

import java.util.ArrayList;
import java.util.List;

public class MySubset {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();

        int[] arr = new int[] {1, 2, 3, 4, 5};
        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    temp.add(arr[j]);
                }
            }

            results.add(temp);
        }

        // 출력
        for (List<Integer> list : results) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
