package org.example.permutationandcombination.combination.bitmask;

import java.util.ArrayList;
import java.util.List;

public class CombinationImplement {
    private static int[] arr = {1, 2, 3, 4, 5};
    private static List<List<Integer>> results = new ArrayList();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = arr.length;
        int howMany = 3;

        for (int i = 0; i < (1 << N); i++) {
            int count = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    count += 1;
                }
            }

            if (count == howMany) {
                List<Integer> temp = new ArrayList();

                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) > 0) {
                        temp.add(arr[j]);
                    }
                }

                results.add(temp);
            }

        }

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                sb.append(results.get(i).get(j)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
