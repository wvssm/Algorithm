// 알파벳 방향 -> 그리디 (이동이 적은 걸로)
// 커서의 이동 -> 그리디로 하니까 케이스가 너무 많음,, 완탐으로 간다! BFS -> 최단거리 보장 BFS로간다
#include <string>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int solution(string name) {
    int answer = 0;
    
    // 초기 문자열 만들기
    string start_str = "";
    for(int i=0; i<name.size(); i++){
        start_str += "A";
    }
    
    queue<tuple<string, int, int>> q;
    q.push(make_tuple(start_str,0,0));
    
    while(!q.empty()){
        auto node = q.front(); q.pop();
        string now_str = get<0>(node);
        int cur = get<1>(node);
        int cnt = get<2>(node);
        
        if(now_str[cur]!=name[cur]){
            int right = name[cur]-now_str[cur];
            int left = 26 - (name[cur]-now_str[cur]);
            
            if(right<left) cnt += right;
            else cnt += left;
            
            now_str[cur] = name[cur];
        }
        
        if(now_str == name){
            return cnt;
        }
        
        int plus = cur + 1;
        if(plus > name.size() - 1){
            plus = plus - name.size();
        }
        
        int minus = cur - 1;
        if(minus < 0){
            minus = name.size() + minus;
        }
        
        q.push(make_tuple(now_str,plus,cnt+1));
        q.push(make_tuple(now_str,minus,cnt+1));
    }
    
    return answer;
}