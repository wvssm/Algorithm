// 우선 phone_book에 있는 전화번호들을 map에 담음
// 다시 phone_book을 순회하면서 각 글자를 한 글자씩 더해서 hashmap에 존재하는지 확인
// 해당 원래 글자와 같은 hashmap이 아니라면 false 반환

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> um;

bool solution(vector<string> phone_book) {
    bool answer = true;
    for(auto phone:phone_book){
        um[phone] = 1;
    }
    
    for(auto phone:phone_book){
        string phone_num = "";
        for(int i=0; i<phone.size(); i++){
            phone_num = phone_num + phone[i];
            if( um[phone_num]==1 && phone_num != phone){
                return false;
            }
        }
    }
    return answer;
}