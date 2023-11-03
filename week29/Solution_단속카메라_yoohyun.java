import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int min = routes[0][1];
        answer++;
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= min) continue;
            answer++;
            min = routes[i][1];
        }
        
        return answer;
    }
}
