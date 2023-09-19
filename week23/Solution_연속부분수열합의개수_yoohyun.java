import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int length = elements.length;
        int sum;
        for(int i = 0; i < length; i++){
            sum = 0;
            for(int j = 0; j < length; j++){
                sum += elements[(i + j) % length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
