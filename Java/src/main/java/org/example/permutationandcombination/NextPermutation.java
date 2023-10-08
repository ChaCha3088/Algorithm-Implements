package org.example.permutationandcombination;

import java.util.Arrays;

public class NextPermutation {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        arr = new int[] {1, 2, 4, 4};

        // arr 정렬
        Arrays.sort(arr);

        do {
            sb.append(Arrays.toString(arr) + "\n");
        } while (nextPermutation());

        System.out.println(sb);
    }

    private static boolean nextPermutation() {
        // 꼭대기 index
        int topIndex = arr.length - 1;

        // 오른쪽부터 왼쪽으로 탐색하며, 가장 왼쪽 꼭대기를 찾는다.
        while (topIndex >= 1 && arr[topIndex - 1] >= arr[topIndex]) {
            topIndex -= 1;
        }

        // 꼭대기가 없다면, 마지막 순열이다.
        if (topIndex <= 0) {
            return false;
        }

        // 꼭대기를 제외한 나머지 부분 중, 꼭대기 바로 왼쪽 값보다 큰 값 중 가장 작은 값을 찾는다.
        int j = arr.length - 1;
        while (arr[j] <= arr[topIndex - 1]) {
            j -= 1;
        }

        // 찾은 값을 꼭대기 바로 왼쪽 값과 swap 한다.
        swap(topIndex - 1, j);

        // 꼭대기를 제외한 나머지 부분을 오름차순으로 정렬한다.
        j = arr.length - 1;
        while (topIndex < j) {
            swap(topIndex, j);
            topIndex += 1;
            j -= 1;
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
