#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    queue<int> q;
    int sum = 0;
    int start = 0;
    
    int head = 0;
    int tail = 1000001;
    for(int i=0; i<sequence.size(); i++){
        q.push(sequence[i]);
        sum += sequence[i];
        while(sum>k){
            sum -= q.front();
            q.pop();
            start += 1;
        }
        if(sum==k){
            if(q.size()-1 < tail - head){
                head = start;
                tail = start + q.size()-1;
            }
            sum -= q.front();
            q.pop();
            start += 1;
        }
        
    }
    
    answer.push_back(head);
    answer.push_back(tail);
    return answer;
}