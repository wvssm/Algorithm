#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    vector<int> max_e;
    vector<int> min_e;
    
    for(int i=0; i<sizes.size(); i++){
        max_e.push_back(max(sizes[i][0],sizes[i][1]));
        min_e.push_back(min(sizes[i][0],sizes[i][1]));
    }
    
    int g_max = *max_element(max_e.begin(), max_e.end());
    int s_max = *max_element(min_e.begin(), min_e.end());
    
    return g_max*s_max;
}