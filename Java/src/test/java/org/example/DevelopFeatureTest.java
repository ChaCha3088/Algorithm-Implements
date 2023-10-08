package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DevelopFeatureTest {

    @Test

    public void solution() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
//            Set<Integer> integers = values;
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        int[] answer =  Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        int[] verify = {2, 1};
        
        Map<Integer, Integer> map = new HashMap<>();
        Object[] objects = map.values().toArray();
//

        Assertions.assertThat(answer).isEqualTo(verify);
    }
}
