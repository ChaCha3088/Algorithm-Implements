package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;

public class HIndexTest {
    private List<Integer> sortedCitations;
    private int n = 0;

    @Test
    public void solution() {
        int[] citations = {1,2,3,8,5,9,7};
        //1,2,3,5,7,8,9
        //3

        int answer = 0;

        n = citations.length;

        //Array to List
        List<Integer> citationList = Arrays.stream(citations)
                .boxed()
                .collect(Collectors.toList());

        //정렬
        this.sortedCitations = citationList.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("sortedCitations = " + sortedCitations);

        answer = calculate(0, n - 1);
        System.out.println("answer = " + answer);

        Assertions.assertThat(answer).isEqualTo(3);
    }

    private int calculate(int firstIndex, int lastIndex) {
        int answer = -1;

        //중앙값을 h로 시작
        int hIndex = medium(firstIndex, lastIndex);
        int h = sortedCitations.get(hIndex);

        //h번 이상 인용된 논문
        int m = count(sortedCitations, h, firstIndex, lastIndex);

        //나머지 논문
        int r = n - m;

        if (m == h) {
            return h;
        }

        //r >= h
        //h가 작다는 뜻이므로
        //h의 인덱스의 오른쪽 중앙값
        if (r >= h) {
            answer = calculate(hIndex + 1, lastIndex);
        }

        //h >= m
        //h가 크다는 뜻이므로
        //h의 인덱스의 왼쪽 중앙값
        if (h >= m) {
            answer = calculate(firstIndex, hIndex - 1);
        }

        return answer;
    }

    //h번 이상 인용된 논문
    private int count(List<Integer> list, int h, int firstIndex, int lastIndex) {
        int count = 0;

        for (int i = firstIndex; i < lastIndex + 1; i++) {
            if (list.get(i) >= h) {
                count += 1;
            }
        }

        return count;
    }

    //중앙값의 index를 구해주는 메소드
    private int medium(int firstIndex, int lastIndex) {
        int result = -1;
        int sub = lastIndex - firstIndex;

        if (sub % 2 == 0) {
            result = firstIndex + sub / 2;
        } else if (sub % 2 == 1) {
            result = firstIndex + (sub / 2) + 1;
        }

        return result;
    }
}
