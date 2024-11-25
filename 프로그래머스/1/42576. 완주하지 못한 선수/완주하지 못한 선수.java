/*
풀이 방법
map을 이용해여 participant을 순회하면서 사람이름을 key 그리고 숫자를 1씩 높인다.
completion을 순회하여 사람이름을 key로 하여 숫자를 1씩 뺀다. 
숫자가 1이상이면 완주하지 못한 사람 이름을 반환한다.
*/

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> personMap = new HashMap<>();
        
        for(String person : participant){
            personMap.put(person, personMap.getOrDefault(person, 0)+1);
        }
        
        for(String person : completion){
            personMap.put(person, personMap.getOrDefault(person, 0)-1);
        }
        
        for(String person : personMap.keySet()){
            if(personMap.get(person)!=0){
                return person;
            }
        }
        
        return answer;
    }
}