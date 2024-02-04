#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

bool isS(int num){
    for(int i=2; i<=sqrt(num); i++){
        if(num%i==0) return false;
    }
    return true;
}
int solution(vector<int> nums) {
    int answer = 0;

    // 3중 for문으로 3개 고르기
    int n = nums.size();
    for(int i=0; i<n-2; i++){
        for(int j=i+1; j<n-1; j++){
            for(int k=j+1; k<n; k++){
                if(isS(nums[i]+nums[j]+nums[k])) answer++;
            }
        }
    }
    // for문 돌려서 소수인지 체크하기
    
    // cout << "Hello Cpp" << endl;

    return answer;
}