import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        String tmp;
        for(int i = 0; i < cities.length; i++){
            tmp = cities[i].toLowerCase();
            answer += map.getOrDefault(tmp, 0) == 0 ? 5 : 1;
            cachingByLRU(queue, map, tmp, cacheSize);
        }
        
        return answer;
    }
    
    void cachingByLRU(Queue<String> queue, HashMap<String, Integer> map, String s, int cacheSize){
        map.put(s, map.getOrDefault(s, 0) + 1);
        queue.add(s);
        
        String tmp;
        while(map.size() > cacheSize){
            tmp = queue.remove();
            if(map.get(tmp) == 1){
                map.remove(tmp);
            } else {
                map.put(tmp, map.get(tmp) - 1);      
            }
        }
    }
}
