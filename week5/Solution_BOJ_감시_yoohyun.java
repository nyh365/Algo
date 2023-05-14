import java.io.*;
import java.util.*;

public class Main {
    static int[][] office;
    static int result = Integer.MAX_VALUE;
    static int N, M, cctv_c;
    static int[] cctvs_dir = {0, 4, 2, 4, 4, 1};
    static int[][] cctv; // cctv 위치정보, 종류
    static int[] order;
    static int[][][] dx = {{{0},{1},{0},{-1}}
    					,{{-1,1},{0,0}}
    					,{{0,1}, {1,0}, {0, -1}, {-1, 0}}
    					,{{-1,0,1}, {0,1,0}, {1,0,-1},{0,-1,0}}
    					,{{0,0,-1,1}}};
    static int[][][] dy = {{{-1},{0},{1},{0}}
    					,{{0,0},{-1,1}}
    					,{{-1,0}, {0,1}, {1, 0}, {0, -1}}
    					,{{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}}
    					,{{-1,1,0,0}}};
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctv = new int[8][3];

        // 사무실 정보 모두 입력받기
        cctv_c = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] != 0 && office[i][j] != 6) {
                    cctv[cctv_c][0] = j;
                    cctv[cctv_c][1] = i;
                    cctv[cctv_c++][2] = office[i][j];
                }
            }
        }
        
        // cctv의 방향
        order = new int[cctv_c];
        dfs_dir(0);

        System.out.println(result);
    }
    public static void dfs_dir(int cnt) {
        if(cnt == cctv_c) {
        	cctv_type();
            return;
        }
        for(int i = 0; i < cctvs_dir[cctv[cnt][2]]; i++) {
            order[cnt] = i;
            dfs_dir(cnt + 1);
        }
    }

    public static void cctv_type() {
        int[][] tmp = copy();
        for(int i = 0; i < order.length; i++) {
        	cctv_zone(i, order[i], tmp);
        }
        count(tmp);
    }
    public static void cctv_zone(int cctv_type, int cctv_dir, int[][] tmp) {
    	int x = cctv[cctv_type][0];
        int y = cctv[cctv_type][1];
        for(int k = 0; k < dx[cctv[cctv_type][2]-1][cctv_dir].length; k++) {
        	int xx = x;
        	int yy = y;
            while(true) {
            	xx += dx[cctv[cctv_type][2]-1][cctv_dir][k];
                yy += dy[cctv[cctv_type][2]-1][cctv_dir][k];
                if(xx >= 0 && xx < M && yy >= 0 && yy < N) {
                    if(tmp[yy][xx] == 6) break;
                    else if(tmp[yy][xx] == 0){
                    	tmp[yy][xx] = -1;
                    }
                }
                else break;
            }
        }
    }
    
    
    public static int[][] copy() {
        int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tmp[i][j] = office[i][j];
            }
        }
        return tmp;
    }
    public static void count(int[][] tmp) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmp[i][j] == 0) count++;
            }
        }
        result = Math.min(result, count);
    }
}
