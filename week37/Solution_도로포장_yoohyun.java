import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long[][] dp;
	static List<Node>[] adjList;
	static class Node implements Comparable<Node>{
		int vertex, cnt;
		long weight;
		public Node(int vertex, long weight, int cnt) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new long[N + 1][K + 1];
		adjList = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<Node>();
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, weight, 0));
			adjList[to].add(new Node(from, weight, 0));
		}
		
		boolean[] check = new boolean[N + 1];
		dp[1][0] = 0;
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(1, dp[1][0], 0));
		while(!pQueue.isEmpty()) {
			Node cur = pQueue.poll();
			
			if (cur.weight > dp[cur.vertex][cur.cnt]) continue;
			
			for(Node tmp : adjList[cur.vertex]) {
				if(dp[tmp.vertex][cur.cnt] >  dp[cur.vertex][cur.cnt] + tmp.weight) {
					dp[tmp.vertex][cur.cnt] =  dp[cur.vertex][cur.cnt] + tmp.weight;
					pQueue.add(new Node(tmp.vertex, dp[tmp.vertex][cur.cnt], cur.cnt));
				}
				if(cur.cnt < K && dp[tmp.vertex][cur.cnt + 1] > dp[cur.vertex][cur.cnt]) {
					dp[tmp.vertex][cur.cnt + 1] =  dp[cur.vertex][cur.cnt];
					pQueue.add(new Node(tmp.vertex, dp[tmp.vertex][cur.cnt + 1], cur.cnt + 1));
				}
				
			}
		}
		
		long min = Long.MAX_VALUE;
        for (long value : dp[N]) {
            min = Math.min(value, min);
        }
		
		System.out.print(min);
	}
}
