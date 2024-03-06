#include <string>
#include <vector>
#include <map>
using namespace std;
int dx[4] = {0,0,-1,1};
int dy[4] = {-1,1,0,0};

map<char,int> m = { 
    {'N',0},{'S',1},{'W',2},{'E',3}
};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int h = park.size();
    int w = park[0].size();
    
    int nh = 0;
    int nw = 0;
    int sign = 0;
    
    for(int i=0; i<park.size(); i++){
        for(int j=0; j<park[i].size(); j++){
            if(park[i][j]=='S'){
                nh = i;
                nw = j;
                break;
            }
        }
    }
    
 
    for(int i=0; i<routes.size(); i++){
        int num = routes[i][2] - '0';
        int new_h = nh;
        int new_w = nw;
        
        while(num--){
            new_h += dy[m[routes[i][0]]];
            new_w += dx[m[routes[i][0]]];
            
            if(new_h<0 || new_h>=h || new_w<0 || new_w>=w) break;
            if(park[new_h][new_w]=='X') break;
        }
        
        if(num<0){
            nh = new_h;
            nw = new_w;
        }
    }
    
    answer.push_back(nh);
    answer.push_back(nw);
    return answer;
}