import java.util.*;
import java.io.*;

public class Main{
    static boolean[][] map;
    static HashMap<Integer, int[]> order;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m, result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                if(Integer.parseInt(st.nextToken()) == 0){
                    map[i][j] = true;
                }
            }
        }

        order = new HashMap<>();
        int x, y;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            order.put(i, new int[]{x, y});
        }
        order.put(m, new int[]{0,0});
        int[] tmp = order.get(0);
        map[tmp[1]][tmp[0]] = false;
        dfs(tmp[0], tmp[1], order.get(1)[0], order.get(1)[1], 1);
        System.out.print(result);
    }
    public static void dfs(int x, int y, int targetX, int targetY, int current){
        if(current == m){
           result++;
           return;
        }
        int xx, yy;
        for(int i = 0; i < 4; i++){
           xx = x + dx[i];
           yy = y + dy[i];
           if(xx < 1 || xx > n || yy < 1 || yy > n) continue;
           if(!map[yy][xx]) continue;
           map[yy][xx] = false;
           if(xx == targetX && yy == targetY){
                dfs(xx, yy, order.get(current + 1)[0], order.get(current + 1)[1], current + 1);
           } else {
                dfs(xx, yy, targetX, targetY, current);
           }
           map[yy][xx] = true;                      
        }    
    }
}
