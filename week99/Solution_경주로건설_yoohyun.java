import java.util.*;

class Solution {
    static int N, result;
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N];  
        
        bfs(board);
        
        return result;
    }
    
    public void bfs(int[][] board) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {0,0,0,-1});
        board[0][0] = 1;
        
        int[] cur;
        while(!pq.isEmpty()) {
            cur = pq.remove();
            
            if(cur[0] == N - 1 && cur[1] == N - 1) {
                result = Math.min(result, cur[2]);
                continue;
            } 
            
            int xx, yy;
            for(int k = 0; k < 4; k++) {
                xx = cur[0] + dx[k];
                yy = cur[1] + dy[k];

                if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                if(board[yy][xx] == 1) continue;
                if(visited[yy][xx] == 0 || visited[yy][xx] >= cur[2] + calCost(cur[3], k)) {
                    visited[yy][xx] = cur[2] + calCost(cur[3], k);
                    pq.add(new int[] {xx, yy, cur[2] + calCost(cur[3], k), k});
                }
                
            }
        }
    }
    
    public int calCost(int preDir, int nextDir) {
        if(preDir == -1) return 100;
        
        if(preDir == 0 || preDir == 1) {
            if(nextDir == 2 || nextDir == 3) return 600;
        }
        
        if(preDir == 2 || preDir == 3) {
            if(nextDir == 0 || nextDir == 1) return 600;
        }
        
        return 100;
    }
}
