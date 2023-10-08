package org.example.tree.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree<T> {
    private Object[] nodes;
    private int lastIndex = 0;
    private final int SIZE;

    public CompleteBinaryTree(int size) {
        this.SIZE = size;
        nodes = new Object[SIZE + 1];
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public boolean add(T input) {
        // 가득 차있으면 false 반환
        if (isFull()) {
            return false;
        }

        // 아니면 저장
        nodes[++lastIndex] = input;
        return true;
    }

    public void bfs() {
        // 비어있으면, 끝
        if (isEmpty()) {
            return;
        }

        // 탐색 순서를 관리할 Queue
        Queue<Integer> queue = new ArrayDeque<>();
        // 탐색 시작 대상(루트 노드)을 넣는다.
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 방문 처리
            System.out.println(nodes[current]);

            // 왼쪽 노드
            if (current * 2 <= lastIndex) {
                queue.offer(current * 2);
            }
            // 오른쪽 노드
            if (current * 2 + 1 <= lastIndex) {
                queue.offer(current * 2 + 1);
            }
        }
    }
}
