import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isVisited; 
	static int[] num, op;
	static int[] order;
	static int N;
	static int minResult = Integer.MAX_VALUE, maxResult = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		op = new int[N - 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				op[cnt++] = i;
			}
		}
		isVisited = new boolean[N - 1];
		order = new int[N - 1];
		dfs(0);
		System.out.print(maxResult + "\n" + minResult);
	}
	public static void dfs(int cnt) {
		if(cnt == N - 1) {
			cal();
			return;
		}
		for(int i = 0; i < N - 1; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			order[cnt] = op[i];
			dfs(cnt + 1);
			isVisited[i] = false;
		}
	}
	
	public static void cal() {
		int result = num[0];
		for(int i = 0; i < N - 1; i++) {
			switch(order[i]) {
				case 0 : result += num[i + 1]; break;
				case 1 : result -= num[i + 1]; break;
				case 2 : result *= num[i + 1]; break;
				case 3 : result /= num[i + 1]; break;
			}
		}
		minResult = Math.min(minResult, result);
		maxResult = Math.max(maxResult, result);
	}
}
