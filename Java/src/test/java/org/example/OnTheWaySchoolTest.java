package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OnTheWaySchoolTest {
    private int[][] map;

    @Test
    void b() {
        int[][] puddles = {};

        Assertions.assertThat(puddles.length).isEqualTo(0);
    }

    @Test
    void a() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int answer = 0;

        map = new int[n][m];

        //puddles를 참고하여 int[][] map을 생성
        if (puddles.length > 0) {
            for (int i = 0; i < puddles.length; i++) {
                map[puddles[i][1]-1][puddles[i][0]-1] = -1;
            }
        }

        for (int j = 0; j < map.length; j++) {
            System.out.println(Arrays.toString(map[j]));
        }

        //-1이 아니면 테두리를 1로
        for (int j = 1; j < map.length; j++) {
            if (map[j-1][0] != -1 & map[j][0] != -1) {
                map[j][0] = 1;
            }
        }

        for (int k = 1; k < map[0].length; k++) {
            if (map[0][k] != -1 & map[0][k-1] != -1) {
                map[0][k] = 1;
            }
        }

        //1,1부터
        explore();

        for (int j = 0; j < map.length; j++) {
            System.out.println(Arrays.toString(map[j]));
        }

        answer = map[n - 1][m - 1] % 1_000_000_007;

        Assertions.assertThat(answer).isEqualTo(0);
    }

    //위와 왼쪽을 더한다.
    private void explore() {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                int sum = 0;

                if (map[i-1][j] != -1) {
                    sum += map[i-1][j];
                }

                if (map[i][j-1] != -1) {
                    sum += map[i][j-1];
                }

                map[i][j] = sum;
            }
        }
    }
}
