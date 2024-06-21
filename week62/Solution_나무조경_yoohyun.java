import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int[][] trees;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        trees = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(N > 2 ? 4 : 2, 0, 0);

        System.out.print(result);
    }
    public static void solve(int max, int cnt, int total){
        if(cnt == max){
            result = Math.max(result, total);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                
                int xx, yy;
                for(int k = 0; k < 2; k++){
                    xx = j + dx[k];
                    yy = i + dy[k];

                    if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                    if(visited[yy][xx]) continue;

                    
                    visited[yy][xx] = true;
                    solve(max, cnt + 1, total + trees[i][j] + trees[yy][xx]);
                    visited[yy][xx] = false;
                }                
                visited[i][j] = false;
            }
        } 
    }
}
