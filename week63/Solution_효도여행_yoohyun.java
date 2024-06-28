import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static LinkedList<Spot>[] edges;
    static char[] S;
    static boolean[] visited;
    static int[][] dp = new int[5001][5001];
    static class Spot {
        int to;
        char alp;
        
        public Spot(int to, char alp){
            this.to = to;
            this.alp = alp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        S = br.readLine().toCharArray();
        edges = new LinkedList[N];
        for(int i = 0; i < N; i++){
            edges[i] = new LinkedList<>();
        }
        int from, to;
        char alp;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            alp = st.nextToken().charAt(0);
            
            edges[from].add(new Spot(to, alp));
            edges[to].add(new Spot(from, alp));
        }

        visited = new boolean[N];
        visited[0] = true;
        dfs(1,0);
        
        System.out.print(result);
    }
    public static void dfs(int dept, int cur){
        boolean isLeaf = true;
        
        for(Spot spot : edges[cur]){
            if(visited[spot.to]) continue;
            isLeaf = false;
            
            visited[spot.to] = true; 

            for(int i = 0; i < S.length; i++){
                if(S[i] == spot.alp){
                    dp[dept][i + 1] = dp[dept - 1][i] + 1;
                } else {
                    dp[dept][i + 1] = Math.max(dp[dept][i], dp[dept - 1][i + 1]);
                }
            }    
            
            dfs(dept + 1, spot.to);
            visited[spot.to] = false;
        }
        
        if(isLeaf){
            result = Math.max(result, dp[dept - 1][S.length]);
            return;    
        }
    } 
}
