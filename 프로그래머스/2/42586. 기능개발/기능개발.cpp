#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int g=0;
    while(progresses.size()){
        if(progresses[0]>=100) {
            g++;
            progresses.erase(progresses.begin());
            speeds.erase(speeds.begin());
        }
        else{
            if(g!=0){
                answer.push_back(g);
                g=0;
            }
            for(int i=0; i<progresses.size();i++){
                progresses[i] += speeds[i];
            }
        }
    }
    answer.push_back(g);

    // 대가리가 100될때까지 계속 speed를 더한다
    // 다음 대가리가 100미만 일때 까지 계속 수를 더한다
    // 벡터에 삽입한다.
    return answer;
}