#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define ITER 8

using namespace std;


int arr[ITER];
int iter = ITER;
int temp;

int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("sortInput.txt", "r", stdin);

    for (int i = 0; i < iter; i++) {
        cin >> arr[i];
    }

    //버블 정렬
    //최상, 평균, 최악 모두 일정
    //시간복잡도 O(n^2)
    //공간복잡도 O(1)
    for (int i = 0; i < iter - 1; ++i) {
        for (int j = 0; j < iter - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
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