import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] words;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// a n t i c
		int cnt = 5;
		words = new int[N];
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 4; j < input.length - 4; j++) {
				if(input[j] == 'a' || input[j] == 'n' || input[j] == 't' || input[j] == 'i' || input[j] == 'c') continue;
				words[i] = words[i] | (1 << (input[j] - 'a'));
			}
		}
		if(cnt < 5) System.out.println(0);
		else if(K == 26){
			System.out.println(N);
		} else {
			combination(0, K - 5, 0);
			System.out.println(result);
		}
	}
	public static void combination(int cur, int K, int used) {
		if(K == 0) {
			result = Math.max(result, countWords(used));
			return;
		}
		if(cur > 25) return;
		// 부분집합
		if(cur == ('a' - 'a') || cur == ('n' - 'a') || cur == ('t' - 'a') || cur == ('i' - 'a') || cur == ('c' - 'a')) {
			combination(cur + 1, K, used);
		}
		else{
			combination(cur + 1, K, used);
			combination(cur + 1, K - 1, used | (1 << cur));
		}
	}
	public static int countWords(int used) {
		int cnt = 0;
		for(int i = 0; i < words.length; i++) {
			if((words[i] & used) == words[i]) cnt++;
		}
		return cnt;
	}
}
