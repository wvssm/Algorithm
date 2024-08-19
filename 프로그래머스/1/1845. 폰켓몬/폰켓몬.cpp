#include <vector>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
    int pocketmon_size = nums.size();
    set<int> kind;
    for(int i=0; i<pocketmon_size; i++){
        kind.insert(nums[i]);
    }
    if(pocketmon_size/2 < kind.size()) return pocketmon_size/2;
    else return kind.size();
}