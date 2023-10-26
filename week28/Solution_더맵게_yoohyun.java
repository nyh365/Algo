import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a,b));
        for(int num : scoville){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.remove();
            if(cur >= K){
                break;
            }
            if(pq.isEmpty()){
                break;
            }
            answer++;
            int second = pq.remove();
            pq.add(cur + second * 2);
        }
        return answer;
    }
}
