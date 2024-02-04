#include <string>
#include <vector>
#include <cmath>

using namespace std;

int divider(int num){
    int ans = 0;
    for(int i=1; i<=sqrt(num); i++){
        if(num%i==0){
            if(i!=num/i) ans += 2;
            else ans +=1;
        }
    }
    return ans;
}
int solution(int number, int limit, int power) {
    int answer = 0;
    int div = 0;
    for(int i=2; i<=number; i++){
        div = divider(i);
        if(div>limit) answer += power;
        else answer += div;
    }
    return answer+1;
}