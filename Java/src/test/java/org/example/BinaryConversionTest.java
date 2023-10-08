package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryConversionTest {

    private int count = 0;
    private int zeroCount = 0;

    @Test
    public void solution() {
        String s = "110010101001";

        String start = s;

        while (!start.equals("1")) {
            start = binary(convert(start));
            this.count += 1;
        }

        int[] answer = {this.count, this.zeroCount};

        Assertions.assertThat(answer).isEqualTo(Arrays.asList(3,8));
    }

    private int convert(String str) {
        System.out.println(str);
        char[] splitted = str.toCharArray();

        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i] != 0) {
                arrayList.add(1);
            } else if (splitted[i] == 0) {
                this.zeroCount += 1;
            }
        }
        System.out.println(arrayList.size());
        return arrayList.size();
    }

    private String binary(int input) {
        List<Integer> arrayList = new ArrayList<>();

        int target = input;

        while (target >= 2) {
            arrayList.add(target % 2);
            target = target / 2;
        }

        String result = "";

        for (int i = 0; i < arrayList.size(); i++) {
            result = result + arrayList.get(arrayList.size() - 1 - i);
        }

        System.out.println(result);

        return result;
    }
}
