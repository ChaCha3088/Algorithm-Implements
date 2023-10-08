package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class DoubleArrayTest {
    @Test
    public void solution() {
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        int size1 = arr1.length;
        int size2 = arr1[0].length;

        int[][] answer = new int[size1][size2];

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
                System.out.println(answer[i][j]);
            }

        }

        System.out.println(answer.toString());

        Assertions.assertThat(answer).isEqualTo(Arrays.array(Arrays.array(4,6),Arrays.array(7,9)));


    }
}
