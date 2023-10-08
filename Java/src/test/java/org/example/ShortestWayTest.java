package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestWayTest {

    int[][] maps;
    static int[][] visited;
    int m, n;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    @Test
    void test() {
        Assertions.assertThat(solution()).isEqualTo(11);
    }

    public int solution() {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        this.maps = maps;

        bfs();

        if (visited[m - 1][n - 1] == 0) {
            System.out.println("result = " + -1);
            return -1;
        } else {
            System.out.println("result = " + visited[m - 1][n - 1]);
            return visited[m - 1][n - 1];
        }
    }

    private void bfs() {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            int y = remove[0];
            int x = remove[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //벽에 닿으면 스킵
                if (ny >= m || ny < 0 || nx >= n || nx < 0) continue;

                //안가봤고, 갈 수 있으면
                if (visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    //기록
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }

            for (int i = 0; i < m; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add(visited[i][j]);
                }
                System.out.println("visited map" + list.toString());
            }
            System.out.println("==============================");
        }
    }
}
