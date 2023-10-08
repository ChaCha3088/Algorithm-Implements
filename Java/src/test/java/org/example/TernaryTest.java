package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TernaryTest {
    @Test
    public void solution() {
        int n = 45;
        int answer = 0;

        List<Integer> linkedList = new ArrayList<>();

        int leftover = n;

        //마지막 --- 첫번째
        System.out.println(leftover);

        //진법 변환
        while (leftover != 0) {
            linkedList.add(leftover % 3);
            leftover = leftover / 3;
            System.out.println(leftover);
        }

        System.out.println("linkedList = " + linkedList);

        answer = answer + linkedList.get(0);

        System.out.println(answer);

        for (int i = 1; i < linkedList.size(); i++) {
            answer = answer + linkedList.get(i) * (int) Math.pow(3, i);
            System.out.println(answer);
        }

        Assertions.assertThat(answer).isEqualTo(7);
    }
}
