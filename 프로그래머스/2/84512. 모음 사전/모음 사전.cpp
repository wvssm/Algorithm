// 시간복잡도: O(N^N);
// N이 크다면 최악의 알고리즘이겠지만, N=5이므로 1초 안에 무난하게 연산이 가능하다.

#include <string>
#include <vector>

using namespace std;

int cnt = 0;
int answer = 0;
string moeum = "AEIOU";

void dfs(string str1, string word){
    if(str1 == word){
        answer = cnt;
        return;    
    }
    
    if(str1.size() >= 5){
        return;
    }
    
    for(int i=0; i<5; i++){
        cnt++;
        dfs(str1+moeum[i], word);
    }
}

int solution(string word) {
    dfs("", word);
    return answer;
}