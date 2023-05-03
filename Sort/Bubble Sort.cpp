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
    //서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
    //인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
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