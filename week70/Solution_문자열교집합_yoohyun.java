import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		HashSet<String> set = new HashSet<>();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			set.clear();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				set.add(st.nextToken());
			}
			
			int result = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				if(set.contains(st.nextToken())) {
					result++;
				}
			}

			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
