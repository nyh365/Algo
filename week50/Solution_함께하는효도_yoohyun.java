import java.io.*;
import java.util.*;

public class Main {
    static int[][] fruits, friends;
    static int N, M, result;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fruits = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                fruits[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        friends = new int[M][2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            friends[i][1] = Integer.parseInt(st.nextToken()) - 1;
            friends[i][0] = Integer.parseInt(st.nextToken()) - 1;
        }

        getFruit(0, 1, friends[0][0], friends[0][1], 0);
        System.out.print(result);
    }
    public static void getFruit(int friend, int time, int x, int y, int total){
        int temp = fruits[y][x];
        total += fruits[y][x];
        fruits[y][x] = 0;
        
        if(time == 4){
            if(friend == M - 1) {
                result = Math.max(result, total);
            } else {
                getFruit(friend + 1, 1, friends[friend + 1][0], friends[friend + 1][1], total);    
            }
            fruits[y][x] = temp;
            return;
        }

        int xx, yy;
        for(int k = 0; k < 4; k++){
            xx = x + dx[k];
            yy = y + dy[k];

            if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
            getFruit(friend, time + 1, xx, yy, total);
        }
        
        fruits[y][x] = temp;
    } 
}
