#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    vector<int> fibo (100000,0);
    fibo[1] = 1;
    int i = 2;
    while(i<=n){
        fibo[i] = (fibo[i-1]%1234567+fibo[i-2]%1234567)%1234567;
        i++;
    }

    return fibo[n];
    
}