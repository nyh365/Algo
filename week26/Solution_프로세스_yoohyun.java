import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            q.add(new int[]{priorities[i], i});
        }
        
        while(!pq.isEmpty()){
            answer++;
            while(pq.peek() != q.peek()[0]){
                q.add(q.remove());
            }
            if(q.peek()[1] == location) break;
            pq.remove();
            q.remove();
        }
        
        return answer;
    }
}
