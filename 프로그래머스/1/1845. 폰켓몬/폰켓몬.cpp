#include <vector>
#include <set>
using namespace std;

set<int> s;

int solution(vector<int> nums)
{
    for(int num:nums){
        s.insert(num);
    }

    if(nums.size()/2 < s.size()) return nums.size()/2;
    else return s.size();
}