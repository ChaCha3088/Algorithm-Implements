package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivisorTest {
    @Test
    public void solution() {
        int left = 13;
        int right = 17;
        int answer = 0;

        //짝수, 홀수 ArrayList 만들기
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // 대상 숫자 배열 만들기
        int[] numberArray = new int[right - left + 1];
        int count = 0;

        while (count <= right - left) {
            numberArray[count] = left + count;
            count += 1;
        }

        //약수의 개수 구하기
        for (int i = 0; i < numberArray.length; i++) {
            int quantity = calculateDivisorQuantity(numberArray[i]);
            if (quantity % 2 == 0) {
                even.add(quantity);
            } else {
                odd.add(quantity);
            }
        }

        //짝수는 더하고, 홀수는 빼고
        int evenResult = sum(even);
        System.out.println("even = " + even);
        System.out.println("evenResult = " + evenResult);
        int oddResult = sum(odd);
        System.out.println("odd = " + odd);
        System.out.println("oddResult = " + oddResult);
        answer = answer + evenResult - oddResult;

        Assertions.assertThat(answer).isEqualTo(43);
    }

    private int calculateDivisorQuantity(int input) {
        //결과 ArrayList
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i * i <= input; i++) {
            if (input % i == 0) {
                set.add(i);
                set.add(input / i);
            }
        }

        return set.size();
    }

    private int sum(List<Integer> list) {
        int answer = 0;
        for (int i : list) {
            answer = answer + i;
        }
        return answer;
    }
}
