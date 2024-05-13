#include <string>
#include <vector>
#include <deque>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    deque<int> dq;

    int sum = 0;
    int index = 0;
    int head = 0;
    int min_start = 0;
    int min_end = 0;
    int min_size = 1000000000;

    dq.push_back(sequence[index]);
    sum += sequence[index];
    index++;

    while (!dq.empty()){
        if(sum == k) {
            if(dq.size()<min_size){
                min_start = head;
                min_end = head + dq.size() - 1;
                min_size = dq.size();
            }

            sum -= dq.front();
            dq.pop_front();
            head++;
        }

        else if(sum < k){
            if(index == sequence.size()) break;
            dq.push_back(sequence[index]);
            sum += sequence[index];

            if(sum == k) {
                if(dq.size()<min_size){
                    min_start = head;
                    min_end = head + dq.size() - 1;
                    min_size = dq.size();
                }

                sum -= dq.front();
                dq.pop_front();
                head++;
            }
            index++;
        }
        else if(sum > k){
            sum -= dq.front();
            dq.pop_front();
            head++;
        }
    }

    vector<int> answer = {min_start, min_end};
    return answer;
}

int main(){
    vector<int> sequence = {1, 1, 1, 2, 3, 4, 5};
    int k = 5;
    vector<int> answer = solution(sequence, k);
    cout << answer[0] << ' ' << answer[1];
}