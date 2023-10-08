package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CreateNumberTest {

    Set<Integer> set = new HashSet<>();

    int answer = 0;

    @Test
    void solution() {
        String numbers = "1231";

        String[] splitted = numbers.split("");
        int count = splitted.length;

        List<String> list = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            list.add(splitted[i]);
        }

        //소수 만들기
        for (int length = 1; length <= count; length++) {
            makeNumber(list, "", length);
        }

        List<Integer> setList = new ArrayList<>(set);
        Collections.sort(setList);
        System.out.println(setList);

        List<Integer> resultList = new ArrayList<>();

        //소수 검증
        for (int i : setList) {
            if (i >= 2) {
                if (sosu(i)) {
                    resultList.add(i);
                    answer += 1;
                }
            }
        }

        System.out.println(resultList);

        Assertions.assertThat(answer).isEqualTo(18);
    }

    private boolean sosu(int input) {

        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void makeNumber(List<String> cards, String input, int length) {
        String result = input;

        if (result.length() == length) {
            set.add(Integer.parseInt(result));
            return;
        }

        List<String> arr = new ArrayList<>();
        for (String str : cards) {
            arr.add(str);
        }

        if (result.length() < length) {
            for (int i = 0; i < arr.size(); i++) {
                String number = arr.get(i);
                String temp = result;
                temp += number;
                arr.remove(i);
                makeNumber(arr, temp, length);
                arr.add(i, number);
            }
        }

    }
}
