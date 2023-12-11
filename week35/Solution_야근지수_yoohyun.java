import java.util.*;

class Solution {
   public long solution(int n, int[] works) {
       long answer = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      
       for(int num : works){
           pq.offer(num);
       }
     
       int tmp;

       for(int i = 0; i < n; i++){
           if(pq.isEmpty()) break;
           tmp = pq.remove();

           if(tmp == 1) continue;
           pq.offer(tmp - 1);
       }
     
       while(!pq.isEmpty()){
           answer += Math.pow(pq.remove(), 2);
       }
       return answer;
   }
}
