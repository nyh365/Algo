import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M;
    static int[][] namwoo, ghost;
    static char[][] miro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new char[N][M];
        namwoo = new int[N][M];
        ghost = new int[N][M];
        
        int[] namwooLoc = new int[2];
        LinkedList<int[]> ghostsLoc = new LinkedList<>();
        char[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                miro[i][j] = input[j];
                if(miro[i][j] == 'N'){
                    namwooLoc[0] = j;
                    namwooLoc[1] = i;
                } else if(miro[i][j] == 'G'){
                    ghostsLoc.add(new int[]{j, i});
                }
            }
        }
        ghostBFS(ghostsLoc);
        System.out.print(namwooBFS(namwooLoc) ? "Yes" : "No");
    }
    public static boolean namwooBFS(int[] namwooLoc){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(namwooLoc[0]);
        queue.add(namwooLoc[1]);
        queue.add(1);

        namwoo[namwooLoc[1]][namwooLoc[0]] = 1;
        
        int curX, curY, curCnt, xx, yy;
        while(!queue.isEmpty()){
            curX = queue.remove();
            curY = queue.remove();
            curCnt = queue.remove();

            for(int k = 0; k < 4; k++){
                xx = curX + dx[k];
                yy = curY + dy[k];

                if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
                if(miro[yy][xx] == '#') continue;
                if(namwoo[yy][xx] != 0) continue;

                if(miro[yy][xx] == 'D') return true;
                
                if(ghost[yy][xx] <= curCnt) continue;
                namwoo[yy][xx] = curCnt + 1;
                queue.add(xx);
                queue.add(yy);
                queue.add(curCnt + 1);
            }
        }
        return false;
    }
    public static void ghostBFS(LinkedList<int[]> ghostsLoc){
        Queue<Integer> queue = new LinkedList<>();

        for(int[] loc : ghostsLoc){
            queue.add(loc[0]);
            queue.add(loc[1]);
            queue.add(1);
            ghost[loc[1]][loc[0]] = 1;
        }
        
        int curX, curY, curCnt, xx, yy;
        while(!queue.isEmpty()){
            curX = queue.remove();
            curY = queue.remove();
            curCnt = queue.remove();

            for(int k = 0; k < 4; k++){
                xx = curX + dx[k];
                yy = curY + dy[k];

                if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
                if(ghost[yy][xx] != 0 || miro[yy][xx] == 'D') continue;

                ghost[yy][xx] = curCnt + 1;
                queue.add(xx);
                queue.add(yy);
                queue.add(curCnt + 1);
            }
        }
    }
}
