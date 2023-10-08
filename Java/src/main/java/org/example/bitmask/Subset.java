package org.example.bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subset {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[] {1, 2, 3, 4, 5};
        int N = arr.length;

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