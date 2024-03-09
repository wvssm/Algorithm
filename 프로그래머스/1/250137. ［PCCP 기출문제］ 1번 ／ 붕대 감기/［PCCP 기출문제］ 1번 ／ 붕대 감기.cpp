#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int s = 0;
    int time = 0;
    int first_health = health;
    for(int i=1; i<=attacks[attacks.size()-1][0]; i++){
        if(attacks[time][0]==i){
            s = 0;
            health = health - attacks[time][1];
            time++;
            if(health<=0) return -1;
        }
        
        else{
            if(s==bandage[0]-1){
                s=0;
                health = health + bandage[1] + bandage[2]; 
            }
            else {
                s++;
                health = health + bandage[1];
            }
            if(health>first_health) health = first_health;
        }
    }
    return health;
}