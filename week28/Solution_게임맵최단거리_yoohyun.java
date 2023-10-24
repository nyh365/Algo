import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(0); queue.add(0); queue.add(1);
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int x = queue.remove(); int y = queue.remove();
            int cnt = queue.remove();
            
            if(x == m - 1 && y == n - 1){
                answer = cnt;
            }
            
            int xx, yy;
            for(int k = 0; k < 4; k++){
                xx = x + dx[k];
                yy = y + dy[k];
                
                if(xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                if(visited[yy][xx]) continue;
                if(maps[yy][xx] == 0) continue;
                
                visited[yy][xx] = true;
                queue.add(xx); queue.add(yy); queue.add(cnt + 1);
            }
        }
        return answer;
    }
}
