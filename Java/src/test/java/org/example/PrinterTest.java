package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrinterTest {
    int targetLocation;
    int printCount = 0;

    @Test
    void solution() {
        int[] priorities = {2, 1, 3, 2};
        targetLocation = 2;

        //queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        //priorityqueue
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a <= b ? 1 : -1);
        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        //둘 다 peek해서 다르면 대기목록의 가장 마지막으로
        while (true) {
            // 그냥 인쇄
            if (queue.peek() == pq.peek()) {
                queue.poll();
                pq.poll();
                printCount += 1;

                if (targetLocation == 0) {
                    break;
                } else {
                    targetLocation -= 1;
                }


            } else {
                //대기 목록 가장 뒤로 보내
                int polled = queue.poll();
                queue.offer(polled);

                if (targetLocation == 0)
                    targetLocation = queue.size() - 1;
                else
                    targetLocation -= 1;
            }
        }

        Assertions.assertThat(printCount).isEqualTo(1);
    }
}
