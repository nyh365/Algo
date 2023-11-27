import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int toppingSize = topping.length;
        int[] left = new int[toppingSize];
        int[] right = new int[toppingSize];
        
        HashSet<Integer> set = new HashSet<>();
        int num = 0;
        
        for(int i = 0; i < toppingSize; i++){
            if(!set.contains(topping[i])) {
                set.add(topping[i]);
                num++;
            }
            left[i] = num;
        }
        
        set.clear();
        num = 0;
        
        for(int i = toppingSize - 1; i >= 0; i--){
            if(!set.contains(topping[i])) {
                set.add(topping[i]);
                num++;
            }
            right[i] = num;
        }
        
        for(int i = 0; i < toppingSize - 1; i++){
            if(left[i] == right[i + 1]) answer++;
        }
        
        return answer;
    }
}
