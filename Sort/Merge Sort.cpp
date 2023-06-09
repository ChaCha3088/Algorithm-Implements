#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define ITER 8

using namespace std;

int arr[ITER];
int sorted[ITER];
int iter = ITER;

//병합 정렬
//안정 정렬에 속하며, 분할 정복 알고리즘
//리스트의 길이가 0 또는 1이면 이미 정렬된 것
//정렬되지 않은 리스트는 두개의 비슷한 크기로 나눔
//병합 정렬로 합쳐나감
//두개의 리스트의 값들을 하나씩 비교하여 더 작은 값을 새로운 리스트로 옮긴다.
//시간복잡도
//최악 O(nlogn)
//평균 O(nlogn)
//최상 O(nlogn)
//공간복잡도 O(

void merge(int list[], int left, int mid, int right) {
    int leftIndex, rightIndex, mergedIndex;

    leftIndex = left;
    rightIndex = mid + 1;
    mergedIndex = left;

    while (leftIndex <= mid && rightIndex <= right) {
        if (list[leftIndex] <= list[rightIndex]) {
            sorted[mergedIndex++] = list[leftIndex++];
        } else {
            sorted[mergedIndex++] = list[rightIndex++];
        }
    }

    if (leftIndex > mid) {
        for (int i = rightIndex; i <= right; ++i) {
            sorted[mergedIndex++] = list[i];
        }
    } else {
        for (int i = leftIndex; i <= mid; ++i) {
            sorted[mergedIndex++] = list[i];
        }
    }

    for (int i = left; i <= right; ++i) {
        list[i] = sorted[i];
    }

    //출력
    for (int k = 0; k < iter; ++k) {
        cout << list[k];
        if (k != iter - 1) {
            cout << " ";
        } else if (k == iter - 1) {
            cout << "\n";
        }
    }
}

void mergeSort(int list[], int left, int right) {
    int mid;

    if (left < right) {
        mid = (left + right) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }
}

int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("sortInput.txt", "r", stdin);

    for (int i = 0; i < iter; i++) {
        cin >> arr[i];
    }

    mergeSort(arr, 0, iter - 1);
}