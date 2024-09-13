#include <vector>
#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int main(){
    int card_number  = 0;
    int number = 0;
    vector<int> numbers;
    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> card_number;
    for(int i=0; i<card_number; i++){
        cin >> number;
        pq.push(number);
    }

    int sum = 0;
    int value = 0;

    while(pq.size()>1){
        value = pq.top();
        pq.pop();
        value += pq.top();
        pq.pop();
        pq.push(value);
        sum += value;
        if(pq.size() == 1) break;
    }

    cout << sum;
}