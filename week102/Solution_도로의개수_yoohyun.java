import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] roads;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[M + 1][N + 1];
        
        K = Integer.parseInt(br.readLine());
        roads = new int[K][4];
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.print(findRoute(0, 0));
    }
    
    public static long findRoute(int x, int y) {
        if(dp[y][x] != -1) return dp[y][x];
        
        if(x == N && y == M) {
            return dp[y][x] = 1;
        }
        
        long result = 0;
        
        if(x + 1 <= N) {
            if(canMove(x, y, x + 1, y)) {
                result += findRoute(x + 1, y);
            }
        }
        
        if(y + 1 <= M) {
            if(canMove(x, y, x, y + 1)) {
                result += findRoute(x, y + 1);
            }
        }
        
        return dp[y][x] = result;
    }
    
    public static boolean canMove(int x, int y, int xx, int yy) {
        for(int[] road : roads) {
            if(road[0] == x && road[1] == y && road[2] == xx && road[3] == yy) return false;
            if(road[0] == xx && road[1] == yy && road[2] == x && road[3] == y) return false;
        }
        
        return true;
    }
}
