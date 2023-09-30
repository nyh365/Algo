import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static int N;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] pizzaA = new int[A];
		int[] pizzaB = new int[B];
		
		int totalA = 0;
		for(int i = 0; i < A; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
			totalA += pizzaA[i];
		}

		int totalB = 0;
		for(int i = 0; i < B; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
			totalB += pizzaB[i];
		}
		
		//map을 이용한 모든 누적합 구하기
		int[] dpA = makeSum(pizzaA, totalA);
		int[] dpB = makeSum(pizzaB, totalB);
		
		solve(dpA, dpB);
		
		System.out.print(result);
	}
	
	public static int[] makeSum(int[] pizza, int total){
		int[] dp = new int[N + 1];
		
		int size = pizza.length;
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum = 0;
			for(int j = 0; j < size - 1; j++) {
				sum += pizza[(i + j) % size];
				if(sum > N) continue;
				dp[sum]++;
			}
		}
		
		dp[0]++;
		if(total <= N) dp[total]++;
		
		return dp;
	}
	
	public static void solve(int[] dpA, int[] dpB) {
		int size = dpA.length;
		
		for(int i = 0; i < size; i++) {
			result += dpA[i] * dpB[N - i];
		}
	}
}
