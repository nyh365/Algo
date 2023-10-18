import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st;
        int num;
        for(String input : operations){
            st = new StringTokenizer(input);
            if(st.nextToken().equals("I")){
                num = Integer.parseInt(st.nextToken());
                min.add(num);
                max.add(num);
            } else {
                num = Integer.parseInt(st.nextToken());
                if(min.isEmpty()) continue;
                if(num == 1){
                    num = max.remove();
                    min.remove(num);
                } else {
                    num = min.remove();
                    max.remove(num);
                }
            }
        }
        if(max.isEmpty() || min.isEmpty()) return new int[]{0,0};
        else {
            return new int[]{max.remove(), min.remove()};
        }
    }
}
