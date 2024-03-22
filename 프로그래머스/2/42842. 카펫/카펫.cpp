#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    int x=1;
    int y=(brown-4)/2-x;

    while(1){
        if((x)*(y)==yellow)
            break;
        x++;
        y--;
    }

    answer.push_back(y+2);
    answer.push_back(x+2);
    return answer;
}