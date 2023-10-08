package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PRIM {
    static class Vertex implements Comparable<Vertex> {
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int V, adjMatrix[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < V; j++) {
                 adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        // 트리 정점 표시
        boolean[] visited = new boolean[V];

        // 자신과 트리의 정점간 최소 간선 비용
        int[] minEdge = new int[V];

        Queue<Vertex> pq = new PriorityQueue();

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        pq.offer(new Vertex(0, minEdge[0]));

        // 최소 신장 트리 비용
        int result = 0;

        int min = 0, minVertex = 0, cnt = 0;

        while (!pq.isEmpty()) {
            minVertex = -1;
            min = Integer.MAX_VALUE;

            // 미방문 정점 중 최소 간선 비용의 정점을 선택
            Vertex polled = pq.poll();
            minVertex = polled.no;
            min = polled.weight;

            // 방문 정점에 추가
            // 방문 기록
            visited[minVertex] = true;

            // 신장 트리 비용 누적
            result += min;

            if (++cnt == V) {
                break;
            }

            // 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선 비용 고려(aka 영업타임)
            for (int i = 0; i < V; i++) {
                if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }

            }
        }
    }
}
