import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        int cur;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            
            answer++;
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()){
                cur = queue.remove();
                for(int j = 0; j < n; j++){
                    if(computers[cur][j] == 0) continue;
                    if(visited[j]) continue;
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        return answer;
    }
}
