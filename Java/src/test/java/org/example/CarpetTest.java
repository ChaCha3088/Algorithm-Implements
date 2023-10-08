package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarpetTest {
    int wholeGaro = 0;
    int wholeSero = 0;
    int brownee = 0;
    int yellowee = 0;
    int sero = 0;
    int garo = 0;
    int[] answer;

    @Test
    void solution() {
        int brown = 14;
        int yellow = 4;

        brownee = brown;
        yellowee = yellow;

        sero = (int) Math.sqrt(yellow);

        answer = process();

        Assertions.assertThat(answer).isEqualTo(new int[]{6, 3});
    }

    //짝수면 + 2
    //홀수면 + 1
    private int convert(int input) {
        return input + 2;
    }

    private int[] process() {
        while (yellowee % sero != 0 | ((sero + 2) * ((yellowee / sero) + 2) - yellowee != brownee)) {
            sero -= 1;
        }

        garo = yellowee / sero;

        int wholeSero = convert(sero);
        int wholeGaro = convert(garo);

        if (wholeSero * wholeGaro == (brownee + yellowee)) {
            int[] result = new int[2];
            result[0] = wholeGaro;
            result[1] = wholeSero;
            return result;
        } else {
            return process();
        }
    }
}
