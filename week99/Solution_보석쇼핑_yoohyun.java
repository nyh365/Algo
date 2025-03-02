import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> shopping = new HashMap<>();
        int countType = countAllType(gems);
        
        int length = Integer.MAX_VALUE, headIdx = 0, tailIdx = 0;
        int start = 0, end = 0;
        for(;tailIdx < gems.length; tailIdx++) {
            shopping.put(gems[tailIdx], shopping.getOrDefault(gems[tailIdx], 0) + 1);
            
            if(shopping.size() == countType) {
                while(shopping.get(gems[headIdx]) > 1) {
                    shopping.put(gems[headIdx], shopping.get(gems[headIdx]) - 1);
                    headIdx++;
                }
                
                if(tailIdx - headIdx < length) {
                    length = tailIdx - headIdx;
                    start = headIdx;
                    end = tailIdx;
                }
            }
        }
        
        return new int[] {start + 1, end + 1};
    }
    
    public int countAllType(String[] gems) {
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
    
        for(String gem: gems) {
            if(set.contains(gem)) continue;
            set.add(gem);
            cnt++;
        }
        
        return cnt;
    }
}
