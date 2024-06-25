import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static int N, M, result;
    static HashMap<Integer, int[]> order = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());    
    
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
        
            order.put(i, new int[]{x, y});
        }
        dfs(0, order.get(0)[0], order.get(0)[1]);
        
        System.out.print(result);
    }
    public static void dfs(int curOrder, int curX, int curY){
        if(curOrder == M + 1){
            ++result;
            return;
        }
        
        map[curY][curX] = -1;
        
        if(curX == order.get(curOrder)[0] && curY == order.get(curOrder)[1]){
            dfs(curOrder + 1, curX, curY);
        } else {
            int xx, yy;
            for(int k = 0; k < 4; k++){
                xx = curX + dx[k];
                yy = curY + dy[k];
    
                if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                if(map[yy][xx] == 1 || map[yy][xx] == -1) continue;

                dfs(curOrder, xx, yy);
                
            }            
        }
        map[curY][curX] = 0;
    }
}
