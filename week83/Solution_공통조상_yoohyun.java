import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N, V, dept,result;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test_case; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            //트리의 높이 구하기
            dept = 1;
            while(1 << (dept - 1) < N) dept++;
            
            depth = new int[N + 1];
            parent = new int[N + 1][dept];
            
            tree = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
            }
          
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= V; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
            }
            
            dfs(1,1);
            makeParent();
            
            //공통조상 구하기
            int lca = LCA(A, B);
            
            result = 0;
            inOrder(lca);
            sb.append(lca).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    public static int LCA(int A, int B) {
        if(depth[A] < depth[B]) {
            int tmp = A;
            A = B;
            B = tmp;
        }
        
        for(int i = dept - 1; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[A] - depth[B]) {
                A = parent[A][i];
            }
        }
        
        if(A == B) return A;
        
        for(int i = dept - 1; i >= 0; i--) {
            if(parent[A][i] != parent[B][i]) {
                A = parent[A][i];
                B = parent[B][i];
            }
        }
        return parent[A][0];
    }
    public static void makeParent() {
        for(int i = 1; i < dept; i++) {
            for(int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }
    public static void inOrder(int idx) {
        result++;
        if(tree[idx].size() > 0) {
            for(Integer child : tree[idx]) {
                inOrder(child);
            }
        }
        return;
    }
}
