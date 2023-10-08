package org.example.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {
    private static int[] arr = new int[21];
    public static void main() throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int myChew = 20;
        int whoIsLast = -1;

        int newOne = 1;

        while (myChew > 0) {
            int poll = queue.poll();
            myChew -= ++arr[poll];
            whoIsLast = poll;
            queue.offer(poll);
            newOne += 1;

            queue.offer(newOne);
        }

        System.out.println(whoIsLast);

    }
}
