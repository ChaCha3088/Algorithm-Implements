#include <iostream>
#include <stack>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define ITER 5

using namespace std;

stack<int> s1, s2;
int input;
int tmp;

void push(int x) {
    s1.push(x);
}

int pop() {
    //s2가 비어있으면 s1의 모든 원소를 s2로 옮긴다.
    if (s2.empty()) {
        //s1을 s2로 옮긴다.
        while (!s1.empty()) {
            s2.push(s1.top());
            s1.pop();
        }

        //s2가 비어있으면 -1을 반환한다.
        if (s2.empty()) {
            return -1;
        }

        //s2의 top을 반환한다.
        tmp = s2.top();
        s2.pop();
        return tmp;

    //s2가 비어있지 않으면 s2의 top을 반환한다.
    } else {
        tmp = s2.top();
        s2.pop();
        return tmp;
    }
}

int size() {
    return s1.size() + s2.size();
}



int main() {
    fastIo;

    //입력
    FILE *pFile = freopen("input.txt", "r", stdin);

    for (int i = 0; i < ITER; i++) {
        cin >> input;
        s1.push(input);
    }

    cout << "size: " << size() << "\n";

    cout << "popValue: " << pop() << "\n";
    cout << "popValue: " << pop() << "\n";

    cout << "size: " << size() << "\n";

    cout << "pushValue: " << 6 << "\n";
    push(6);
    cout << "pushValue: " << 7 << "\n";
    push(7);

    cout << "size: " << size() << "\n";

    cout << "popValue: " << pop() << "\n";
    cout << "popValue: " << pop() << "\n";
    cout << "popValue: " << pop() << "\n";
    cout << "popValue: " << pop() << "\n";

    cout << "size: " << size() << "\n";
}