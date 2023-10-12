import java.util.*;

class Solution {
    final int MUL = 65536;
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        hashing(str1, map1);
        hashing(str2, map2);
        
        if(map1.size() == 0 && map2.size() == 0){
            return MUL;
        }
        
        double common = 0;
        
         for(int key : map2.keySet()){
            if(map1.containsKey(key)){
                common += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        double union = 0;
        for(int key : map1.keySet()){
            union += map1.get(key);
        }
        for(int key : map2.keySet()){
            union += map2.get(key);
        }
        union -= common; 
        return (int) (common / union * MUL);
    }  
    
    void hashing(String s, HashMap<Integer, Integer> map){
        int tmp = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) < 'a' || s.charAt(i - 1) > 'z') continue;
            if(s.charAt(i) < 'a' || s.charAt(i) > 'z') continue;
            tmp = (s.charAt(i - 1) + 1 - 'a') << 5 | (s.charAt(i) + 1 - 'a');
             
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
    }
}
