import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < discount.length; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if(i >= 10){
                map.put(discount[i - 10], map.get(discount[i - 10]) - 1);    
            }
            if(isOK(map, want, number)) answer++;
        } 
        return answer;
    }
    boolean isOK(HashMap<String, Integer> map, String[] want, int[] number){
        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], 0) < number[i]) return false;
        }
        return true;
    }
}
