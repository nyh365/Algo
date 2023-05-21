import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int result_max = Integer.MIN_VALUE;
	static int N;
	static Work work[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		work = new Work[N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		func(1, 0);
		System.out.print(result_max);
	}
	static class Work{
		int days;
		int pay;
		Work(int days, int pay){
			this.days = days;
			this.pay = pay;
		}
	}
	public static void func(int cur, int sum) {
		if(cur == N + 1) {
			result_max = Math.max(result_max, sum);
			return;
		}
		else if(cur > N + 1)
			return;
		func(cur + work[cur].days, sum + work[cur].pay);
		func(cur + 1, sum);
	}
}
