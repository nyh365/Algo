import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] islands;
	static class Edge implements Comparable<Edge>{
		int from, to;
		long dis;
		
		public Edge(int from, int to, long dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}
		
		public int compareTo(Edge edge) {
			return Long.compare(this.dis, edge.dis);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		int N;
		long[] x, y;
		double E;
		PriorityQueue<Edge> pq;
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			init(N);
			x = new long[N + 1];
			y = new long[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			pq = new PriorityQueue<>();
			for(int i = 1; i <= N; i++) {
				for(int j = i + 1; j <= N; j++) {
					pq.add(new Edge(i, j,(x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j]) * (y[i]-y[j])));
				}
			}
			
			long result = 0;
			Edge cur;
			while(!pq.isEmpty()) {
				cur = pq.remove();
				if(union(cur.from, cur.to)) {
					result += cur.dis;
				}
			}
			
			sb.append(Math.round(E * result)).append("\n");
		}
		System.out.print(sb);
	}
	public static void init(int N) {
		islands = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			islands[i] = i;
		}
	}
	public static int find(int a) {
		if(islands[a] == a) {
			return a;
		}
		
		return islands[a] = find(islands[a]);
	}
	public static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A == B) {
			return false;
		}
		
		islands[A] = B;
		return true;
	}
}
