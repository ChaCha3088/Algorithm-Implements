#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define ITER 8

using namespace std;

int arr[ITER];
int iter = ITER;
int keyValue;

int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("sortInput.txt", "r", stdin);

    for (int i = 0; i < iter; i++) {
        cin >> arr[i];
    }

    //삽입 정렬
    //카드를 정렬하는 방법과 유사
    //두번째 수부터 그 왼쪽에 있는 수들과 비교하여 정렬
    //시간복잡도
    //최악 O(n^2)
    //평균 O(n^2)
    //최상 O(n)
    //공간복잡도 O(1)
    for (int i = 1; i < iter; ++i) {
        keyValue = arr[i];

        for (int j = i - 1; j >= 0 & arr[j] > keyValue; --j) {
            arr[j + 1] = arr[j];
            arr[j] = keyValue;
        }

        //출력
        for (int k = 0; k < iter; ++k) {
            cout << arr[k];
            if (k != iter - 1) {
                cout << " ";
            } else if (k == iter - 1) {
                cout << "\n";
            }
        }
    }
}