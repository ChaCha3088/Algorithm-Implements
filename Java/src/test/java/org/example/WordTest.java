package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {

    @Test
    public void solution() {
        String s = "try hello world";
        String answer = "";

        char[] splitted = s.toCharArray();

        int count = 0;

        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i] == ' ') {
                count = 0;
                continue;
            }

            splitted[i] = convert(splitted[i], count);
            count += 1;
        }

        //
        answer = String.valueOf(splitted);

        Assertions.assertThat(answer).isEqualTo("TrY HeLlO WoRlD");
    }

    private char convert(char character, int count) {
        if (count % 2 == 0) {
            character = Character.toUpperCase(character);
        } else if (count % 2 == 1) {
            character = Character.toLowerCase(character);
        }

        return character;
    }
}
