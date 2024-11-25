import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();
        
        int max_val = nums.length / 2;
        
        for(int num : nums){
            numSet.add(num);
        }
        
        if(numSet.size() > max_val){
            return max_val;
        }
        
        return numSet.size();
    }
}