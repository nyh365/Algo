import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] loc = new int[2];
        char[][] board = new char[N][M];
        boolean[][][] check = new boolean[N][M][64];

        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                board[i][j] = input[j];
                if(board[i][j] == '0') {
                    loc[0] = j;
                    loc[1] = i;
                }
            }
        }
        
        boolean flag = false;
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue.add(loc[0]); queue.add(loc[1]); queue.add(0);
        check[loc[1]][loc[0]][0] = true;
        while(!queue.isEmpty()) {
            int x = queue.remove();
            int y = queue.remove();
            int key = queue.remove();	

            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                int kkey = key;
                //경계값을 넘을 때
                if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
                //목적지에 도착했을 떄
                if(board[yy][xx] == '1') {
                	time++;
                    flag = true;
                    break;
                }
                // 이동하고자 하는 위치가 벽일 때
                if(board[yy][xx] == '#') continue;
                if(check[yy][xx][kkey]) continue;
                if(board[yy][xx] >= 'a' && board[yy][xx] <= 'f') {
                	if(check[yy][xx][kkey | (1 << (board[yy][xx] - 'a'))]) continue;
                	kkey |= (1 << (board[yy][xx] - 'a'));
                }
                // 이동하고자 하는 위치가 문일 때
                if(board[yy][xx] >= 'A' && board[yy][xx] <= 'F') {
                    if((kkey & (1 << (board[yy][xx] - 'A'))) <= 0) continue;
                }
                check[yy][xx][kkey] = true;
                queue2.add(xx); queue2.add(yy);queue2.add(kkey);
            }
            if(flag) break;
            if(queue.isEmpty()) {
                time++;
                while(!queue2.isEmpty()) {
                    queue.add(queue2.remove());
                }
            }

        }

        if(!flag) time = -1; 
        System.out.println(time);
    }
}
