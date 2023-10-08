package org.example.disjointset;

import java.util.Arrays;

public class DisjointSetWithTree {
    // 초기 집합의 개수
    private static int N;

    private static int[] parents;


    public static void main(String[] args) {
        N = 5;

        makeSet();

        System.out.println(Arrays.toString(parents));

        System.out.println(unionSet(0, 1));

        System.out.println(Arrays.toString(parents));

        System.out.println(unionSet(2, 1));

        System.out.println(Arrays.toString(parents));

        System.out.println(unionSet(3, 2));

        System.out.println(Arrays.toString(parents));

        System.out.println(unionSet(4, 3));

        System.out.println(Arrays.toString(parents));

        System.out.println(findSet(4));

        System.out.println(Arrays.toString(parents));

        System.out.println(findSet(3));

        System.out.println(Arrays.toString(parents));

        System.out.println(findSet(2));

        System.out.println(Arrays.toString(parents));

        System.out.println(findSet(0));

        System.out.println(Arrays.toString(parents));

        System.out.println(findSet(1));

        System.out.println(Arrays.toString(parents));
    }

    private static void makeSet() {
        parents = new int[N];

        // 모든 요소를 자신만 갖는 단위 서로소 집합이 되도록 만든다.
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int target) {
        if (target == parents[target]) {
            return target;
        }

        // 개선 전
        // return findSet(parents[target]);

        // 개선 후
        return parents[target] = findSet(parents[target]);
    }

    // 합칠 수 있으면 true, 아니면 false
    private static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;

        return true;
    }
}
