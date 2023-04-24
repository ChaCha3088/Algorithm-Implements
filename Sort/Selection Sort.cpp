#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int arr[5];
int iter = 5;
int minValue;
int minIndex;

int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("sortInput.txt", "r", stdin);

    for (int i = 0; i < iter; i++) {
        cin >> arr[i];
    }

    //선택 정렬
    //시간복잡도 O(n^2)
    //공간복잡도 O(1)
    for (int i = 0; i < iter - 1; ++i) {
        minValue = arr[i];

        //최소값 찾기
        for (int j = i + 1; j < iter; ++j) {
            if (minValue > arr[j]) {
                minValue = arr[j];
                minIndex = j;
            }
        }

        //처음 선택한 값과 다르다면, 최소값과 자리 바꾸기
        if (minValue != arr[i]) {
            arr[minIndex] = arr[i];
            arr[i] = minValue;
        }

        //출력
        for (int k = 0; k < iter; k++) {
            cout << arr[k];
            if (k != iter - 1) {
                cout << " ";
            } else if (k == iter - 1) {
                cout << "\n";
            }
        }
    }
}