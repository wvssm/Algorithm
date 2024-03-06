#include <string>
#include <vector>

using namespace std;

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
                sign = 1;
                break;
            }
        }
        if(sign) break;
    }
    
    int result = 0;
    for(int i=0; i<routes.size(); i++){
        sign = 0;
        if(routes[i][0]=='N'){
            result = nh-(routes[i][2]-'0');
            if(result >=0 && result <=h-1){
                for(int j=nh; j>=result; j--){
                    if(park[j][nw]=='X') {
                        sign = 1;
                        break;
                    }
                }
                if(sign == 0) nh = result;
            } 
        }
        
        else if(routes[i][0]=='S'){
            result = nh+(routes[i][2]-'0');
            if(result>=0 && result <=h-1) {
                for(int j=nh; j<=result; j++){
                    if(park[j][nw]=='X') {
                        sign = 1;
                        break;
                    }
                }
                if(sign == 0) nh = result;
            }
        } 
        else if(routes[i][0]=='W'){
            result = nw-(routes[i][2]-'0');
            if(result>=0 && result<=w-1) {
                for(int j=nw; j>=result; j--){
                    if(park[nh][j]=='X') {
                        sign = 1;
                        break;
                    }
                }
                if(sign == 0) nw = result;
            } 
        } 
        else if(routes[i][0]=='E'){
            result = nw+(routes[i][2]-'0');
            if(result>=0 && result<=w-1) {
                for(int j=nw; j<=result; j++){
                    if(park[nh][j]=='X') {
                        sign = 1;
                        break;
                    }
                }
                if(sign == 0) nw = result;
            } 
        } 
    }
    answer.push_back(nh);
    answer.push_back(nw);
    return answer;
}