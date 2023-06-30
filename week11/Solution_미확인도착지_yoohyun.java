import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //교차로
			int m = Integer.parseInt(st.nextToken()); //도로
			int t = Integer.parseInt(st.nextToken()); //목적지 후보
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); //예술가의 출발지
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[n + 1];
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()); //예술가의 출발지
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken()) * 2;
				
				adjList[from] = new Node(to, weight, adjList[from]);
				adjList[to] = new Node(from, weight, adjList[to]);
			}
			
			int[] candidate = new int[t];
			for(int i = 0; i < t; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(candidate);
			
			int[] minWeight = new int[n + 1];
			boolean[] check = new boolean[n + 1];
			Arrays.fill(minWeight, Integer.MAX_VALUE);
			minWeight[s] = 0;
			
			PriorityQueue<Node> pQueue = new PriorityQueue<>();
			pQueue.offer(new Node(s, minWeight[s]));
			
			while(!pQueue.isEmpty()) {
				Node minNode = pQueue.poll();
				if(check[minNode.vertex]) continue;
				check[minNode.vertex] = true;
				
				for(Node tmp = adjList[minNode.vertex]; tmp != null; tmp = tmp.next) {
					int tmpWeight = tmp.weight;
					if(tmp.vertex == h && minNode.vertex == g) tmpWeight -= 1;
					if(tmp.vertex == g && minNode.vertex == h) tmpWeight -= 1;
					if(!check[tmp.vertex] && minWeight[tmp.vertex] > minWeight[minNode.vertex] + tmpWeight) {
						minWeight[tmp.vertex] = minWeight[minNode.vertex] + tmpWeight;
						pQueue.offer(new Node(tmp.vertex, minWeight[tmp.vertex]));
					}
				}
			}
			
			for(int i = 0; i < t; i++) {
				if(minWeight[candidate[i]] == Integer.MAX_VALUE) continue;
				if(minWeight[candidate[i]] % 2 == 1) {
					sb.append(candidate[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
