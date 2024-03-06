#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int wmin = 51;
    int wmax = 0;
    int hmin = 51;
    int hmax = 0;
    for(int i=0; i<wallpaper.size(); i++){
        for(int j=0; j<wallpaper[0].size(); j++){
            if(wallpaper[i][j]=='#'){
                if(wmin>j) wmin = j;
                if(wmax<j) wmax = j;
                if(hmin>i) hmin = i;
                if(hmax<i) hmax = i;
            }
        }
    }
    answer.push_back(hmin);
    answer.push_back(wmin);
    answer.push_back(hmax+1);
    answer.push_back(wmax+1);
    return answer;
}