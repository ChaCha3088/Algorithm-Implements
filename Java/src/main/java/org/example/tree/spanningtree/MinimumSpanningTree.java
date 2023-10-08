package org.example.tree.spanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class MinimumSpanningTree {
    private static int V, E;
    private static Edge[] edgeList;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        // 간선 리스트를 가중치 기준으로 오름차순 정렬
        Arrays.sort(edgeList);

        // V개의 정점으로 make set 작업
        make();

        int result = 0;
        int count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;

                if (++count == V - 1) {
                    break;
                }
            }
        }

        System.out.println(result);
    }

    private static void make() {
        parents = new int[V];

        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    private static int find(int target) {
        if (parents[target] == target) {
            return target;
        }

        return parents[target] = find(parents[target]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;

        return true;
    }

}
