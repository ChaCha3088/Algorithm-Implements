#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define ITER 8

using namespace std;

int arr[ITER];
int sorted[ITER];
int iter = ITER;
int tmp;

//퀵 정렬
//불안정 정렬, 비교 정렬, 분할 정복 알고리즘
//병합 정렬과 달리 비균등하게 분할
//시간복잡도
//최악 O(n^2)
//평균 O(nlog n)
//최상 O(nlog n)
//공간복잡도 O(log n)

void swap(int *a, int *b) {
    tmp = *a;
    *a = *b;
    *b = tmp;
}

int partition(int list[], int left, int right) {
    int pivotValue;
    int low, high;

    low = left;
    high = right + 1;
    pivotValue = list[left];

    do {
        do {
            low++;
        } while (low <= right && list[low] < pivotValue);

        do {
            high--;
        } while (high >= left && list[high] > pivotValue);

        if (low < high) {
            swap(&list[low], &list[high]);
        }
    } while (low < high);

    swap(&list[left], &list[high]);

    //출력
    for (int k = 0; k < iter; ++k) {
        cout << list[k];
        if (k != iter - 1) {
            cout << " ";
        } else if (k == iter - 1) {
            cout << "\n";
        }
    }

    return high;
}

void quickSort(int list[], int left, int right) {
    if (left < right) {
        int highPivotIdx = partition(list, left, right);

        quickSort(list, left, highPivotIdx - 1);
        quickSort(list, highPivotIdx + 1, right);
    }
}

int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("sortInput.txt", "r", stdin);

    for (int i = 0; i < iter; i++) {
        cin >> arr[i];
    }

    quickSort(arr, 0, iter - 1);
}