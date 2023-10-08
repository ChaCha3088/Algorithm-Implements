package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    public void solution() {
        String s = "3people unFollowed me         ";

        String answer = "";

        String[] splitted = s.split(" ");

        for (int i = 0; i < splitted.length; i++) {
            splitted[i] = process(splitted[i]);
            System.out.println(splitted[i]);
        }

        answer = String.join(" ", splitted);

        Assertions.assertThat(answer).isEqualTo("3people Unfollowed Me ");
    }

    private String process(String str) {
        String result = "";
        String[] splitted = str.split("");

        // for (int i = 0; i < splitted.length; i++) {
        //     System.out.println(splitted[i]);
        // }


        //첫번째 문자 대문자로
        if (!isInteger(splitted[0])) {
            splitted[0] = splitted[0].toUpperCase();
        }

        //두번째 문자부터 소문자로
        for (int i = 1; i < splitted.length; i++) {
            if (!isInteger(splitted[i])) {
                splitted[i] = splitted[i].toLowerCase();
            }
        }

        for (int i = 0; i < splitted.length; i++) {
            result = result + splitted[i];

        }


        return result;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
