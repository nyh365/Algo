import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] prime = {1,3,5,7,9};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] start = {2,3,5,7};
		for(int i = 0; i < start.length; i++) {
			dfs(1, ""+ start[i]);
		}
		
		System.out.println(sb);
	}
	public static void dfs(int length, String result) {
		if(length == N) {
			sb.append(String.valueOf(result)).append("\n");
			return;
		}
		for(int i = 0; i < prime.length; i++) {
			int num = Integer.valueOf(result + prime[i]);
			if(isPrime(num)) {
				dfs(length + 1, result + prime[i]);
			}
		}
	}
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
