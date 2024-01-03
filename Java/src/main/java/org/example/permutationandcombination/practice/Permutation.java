package org.example.permutationandcombination.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr = {1, 2, 3, 4, 5};
    private static int N = 5;
    private static int K = 3;
    private static boolean[] visited = new boolean[5];
    private static int count = 0;
    private static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        dfs(0);

        System.out.println(sb);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == K) {
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            count += 1;
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
