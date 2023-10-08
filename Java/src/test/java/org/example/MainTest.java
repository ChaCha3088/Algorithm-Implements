package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.*;
import java.util.*;

class MainTest {



    @Test
    void solution() {
        // input
        int[] numlist = {600, 400, 300, 200, 700, 800, 100, 900};
        int n = 500;

        // 복사
        List<Integer> numlistArrayList = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            numlistArrayList.add(numlist[i]);
        }

        // 거리 map
        LinkedHashMap<Integer, Integer> distance = new LinkedHashMap<>();

        for (int i = 0; i < numlist.length; i++) {
            distance.put(i, numlist[i] - n);
        }

        // distance = [(0, -3), (1, -2), (2, -1), (3, 0), (4, 1), (5, 2)]

        //정렬
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(distance.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int o1Abs = Math.abs(o1.getValue());
                int o2Abs = Math.abs(o2.getValue());

                if (o1Abs == o2Abs) {
                    if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() < o2.getValue()) {
                        return 1;
                    }
                } else if (o1Abs > o2Abs) {
                    return 1;
                }
                else if (o1Abs < o2Abs) {
                    return -1;
                }

                return o2.getKey().compareTo(o1.getKey());
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<Integer, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);

        int[] answer = new int[numlist.length];

        int count = 0;
        for (Integer key : sortedMap.keySet()) {
            answer[count] = numlist[key];
            count += 1;
        }

        String myAnswerString = Arrays.toString(answer);
        System.out.println("My answer  = " + myAnswerString);
        int[] expectedAnswer = {600, 400, 700, 300, 800, 200, 900, 100};
        String expectedAnswerString = Arrays.toString(expectedAnswer);
        System.out.println("Expected answer  = " + expectedAnswerString);

        Assertions.assertThat(myAnswerString).isEqualTo(expectedAnswerString);
    }
}