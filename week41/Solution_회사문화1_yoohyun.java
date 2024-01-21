import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] emp;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		emp = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			emp[i] = new ArrayList<>();
		}
		
		int root = -1;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = i;
				continue;
			}
			emp[parent].add(i);
		}
		
		num = new int[N + 1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int empIdx = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			num[empIdx] += w;
		}
		
		dfs(root);
		
		for(int i = 1; i <= N; i++) {
			sb.append(num[i]).append(" ");
		}
		
		System.out.print(sb);
	}
	public static void dfs(int cur) {
		for(int i = 0; i < emp[cur].size(); i++) {
			int childEmp = emp[cur].get(i);
			num[childEmp] += num[cur];
			dfs(childEmp);
		}
	}
}
