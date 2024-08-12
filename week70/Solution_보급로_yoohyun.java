import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
   static int[][] map = new int[100][100];
   static int[][] result = new int[100][100];
   static int[] dx = {0,0,-1,1};
   static int[] dy = {-1,1,0,0};

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       int T = Integer.parseInt(br.readLine());
       char[] input;
       for(int t = 1; t <= T; t++) {

           sb.append("#").append(t).append(" ");
           int N = Integer.parseInt(br.readLine());

           init(N);

           for(int i = 0; i < N; i++) {
               input = br.readLine().toCharArray();

               for(int j = 0; j < N; j++) {
                   map[i][j] = input[j] -'0';
               }
           }
           dijk(N);

           sb.append(result[N - 1][N - 1]).append("'n");
       }
       System.out.print(sb);
   }

   public static void init(int N) {
       for(int i = 0; i < N; i++) {
           Arrays.fill(map[i], 0);
           Arrays.fill(result[i], Integer.MAX_VALUE);
       }
   }

   public static void dijk(int N) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

       pq.add(new int[] {0,0,0});
       int[] cur;
       int xx, yy;

       while(!pq.isEmpty()) {
           cur = pq.remove();

           if(cur[2] > result[cur[1]][cur[0]]) continue;
         
           for(int k = 0; k < 4; k++) {
               xx = cur[0] + dx[k];
               yy = cur[1] + dy[k];

               if(xx < 0 || xx >= N || yy < 0 || yy >= N ) continue;
               if(cur[2] + map[yy][xx] < result[yy][xx]) {
                   result[yy][xx] = cur[2] + map[yy][xx];
                   pq.add(new int[] {xx,yy, result[yy][xx]});
               }
           }
       }
   }
}

