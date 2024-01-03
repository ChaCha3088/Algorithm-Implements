package org.example.permutationandcombination.recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private static int[] arr = {1, 2, 3, 4, 5};
    private static List<List<Integer>> results = new ArrayList();
    private static List<Integer> temp = new ArrayList();
    private static int N, howMany;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = arr.length;
        howMany = 3;
        visited = new boolean[N];


        dfs(0);

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                sb.append(results.get(i).get(j)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == howMany) {
            List<Integer> buffer = new ArrayList<>();

            for (int i = 0; i < temp.size(); i++) {
                buffer.add(temp.get(i));
            }

            results.add(buffer);

            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(arr[i]);

                dfs(depth + 1);

                temp.remove(temp.size() - 1);

                visited[i] = false;
            }
        }

    }
}
