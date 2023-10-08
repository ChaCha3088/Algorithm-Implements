package org.example;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class DiskControllerTest {

    @Test
    public void test() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = 0;
        int currentTime = 0;

        PriorityQueue<int[]> waitingpq = new PriorityQueue<>((a, b) -> a[0] >= b[0] ? 1 : -1);

        for (int i = 0; i < jobs.length; i++) {
            waitingpq.offer(jobs[i]);
        }

        PriorityQueue<int[]> readypq = new PriorityQueue<>((a, b) -> a[1] >= b[1] ? 1 : -1);

        //레디큐가 비어있을 때
        while (readypq.isEmpty()) {
            //웨이팅큐가 비어있지 않다면
            if (!waitingpq.isEmpty()) {
                //레디큐에 등록할게 없으면 기다리기
                if (waitingpq.peek()[0] > currentTime) {
                    currentTime = waitingpq.peek()[0];
                }
                //currentTime보다 작거나 같은거로 레디큐를 채우세요.
                while (waitingpq.peek()[0] <= currentTime) {
                    readypq.offer(waitingpq.poll());
                    if (waitingpq.isEmpty()) {
                        break;
                    }
                }
            }
            //레디큐가 비워질 때까지 처리하세요
            while (!readypq.isEmpty()) {
                int[] polled = readypq.poll();

                //현재 시간 바꾸기
                currentTime += polled[1];

                //요청 종료 시간 재기
                answer = answer + currentTime - polled[0];
            }
        }

        answer /= jobs.length;
    }
}
