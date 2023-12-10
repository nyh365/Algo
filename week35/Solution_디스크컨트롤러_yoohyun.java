import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int[] job : jobs){
            pq.add(job);
        }
        
        int time = 0;
        PriorityQueue<int[]> tmp = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        while(!pq.isEmpty() || !tmp.isEmpty()){
            while(!pq.isEmpty() && time >= pq.peek()[0]){
                    tmp.add(pq.remove());
            }
            if(tmp.isEmpty()){
                time = pq.peek()[0] + pq.peek()[1];
                answer += pq.peek()[1];
                pq.remove();
            } else {
                time += tmp.peek()[1];
                answer += time - tmp.peek()[0];
                tmp.remove();
            }
        }
        
        answer /= jobs.length;
        
        return answer;
    }
}
