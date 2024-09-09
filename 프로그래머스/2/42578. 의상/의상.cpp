// map<string, int>를 선언한다.
// 옷 종류를 key, 해당하는 옷의 개수가 int 이다.
// vector를 순회하면서 +1를 한다.
// 아무것도 안입는 경우를 +1 해서, 각 옷 종류를 곱해서 나올 수 있는 조합을 수를 구한다.
// 아무것도 착용 안한 경우를 -1 해준다.

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> um;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    for(auto clothe : clothes){
        um[clothe[1]] += 1;        
    }
    
    for(auto &i : um){
        answer *= (i.second + 1);
    }
    return answer-1;
}