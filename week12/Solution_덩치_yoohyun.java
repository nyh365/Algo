import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Man{
		int weight, height;
		public Man(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Man[] people = new Man[N];
		int[] rank = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new Man(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			Man cur = people[i];
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(cur.weight >= people[j].weight) continue;
				if(cur.height < people[j].height) rank[i]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(rank[i] + 1).append(" ");
		}
		
		System.out.print(sb);
	}
}

