import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Node[] nodes;
	static int[][] dp;
	static boolean[] visited;
	public static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        init(N);
        
        for(int i = 1; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	nodes[from] = new Node(to, nodes[from]);
        	nodes[to] = new Node(from, nodes[to]);
        }
       
        dfs(1);
        
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
    
    public static void init(int N) {
    	nodes = new Node[N + 1];
    	dp = new int[N + 1][2];
    	visited = new boolean[N + 1];
    }
    
    public static void dfs(int parent) {
    	visited[parent] = true;
    	dp[parent][0] = 0;
		dp[parent][1] = 1;
    	for(Node node = nodes[parent]; node != null; node = node.next) {
    		if(visited[node.vertex]) continue;
    		dfs(node.vertex);
    		dp[parent][0] += dp[node.vertex][1];
    		dp[parent][1] += Math.min(dp[node.vertex][0], dp[node.vertex][1]);
    	}
    }
}
