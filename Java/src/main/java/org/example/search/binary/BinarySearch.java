package org.example.search.binary;

import java.util.Arrays;

public class BinarySearch {
    private static int[] arr;
    public static void main(String[] args) {
        arr = new int[] {1, 6, 6, 6, 5, 5, 5, 4, 2, 8, 8, 1};

        int normalResult1 = binarySearch(5);
        int normalResult2 = binarySearch(4);
        int normalResult3 = binarySearch(3);

//        int 중복되는_값 = upperBound(5);
//        int 없는_값 = upperBound(3);
//        int 존재하는_가장_끝_값 = upperBound(8);
//        int 없는_가장_왼쪽_값 = upperBound(0);

        int 중복되는_값 = lowerBound(5);
        int 없는_값 = lowerBound(3);
        int 존재하는_가장_끝_값 = lowerBound(8);
        int 없는_가장_왼쪽_값 = lowerBound(0);
    }

    private static int binarySearch(int target) {
        // 정렬
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {
                l = mid + 1;
            }
            else if (arr[mid] > target) {
                r = mid - 1;
            }
        }

        // 값이 없으면 음수로 넣을 위치를 알려줌
        return -1 * l;
    }

    private static int upperBound(int target) {
        // 정렬
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            }
            else if (arr[mid] > target) {
                r = mid;
            }
        }

        // 넣어야 할 위치를 return
        return l;
    }

    private static int lowerBound(int target) {
        // 정렬
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= target) {
                r = mid;
            }
            else if (arr[mid] < target) {
                l = mid + 1;
            }
        }

        // 넣어야 할 위치를 return
        return l;
    }
}
