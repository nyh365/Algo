import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int key : map.keySet()){
            pq.add(map.get(key));
        }
        
        while(!pq.isEmpty() && k > 0){
            k -= pq.remove();
            answer++;
        }
        
        return answer;
    }
}
