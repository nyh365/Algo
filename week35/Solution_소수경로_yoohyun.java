import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 10000;
	static boolean prime[] = new boolean[MAX];
	
	public static void main(String args[]) throws Exception{
		ArrayList<Integer> list = new ArrayList<>();
		prime[1] = true;
		for(int i = 2; i < MAX; i++) {
			if(!prime[i]) {
				list.add(i);
				for(int j = i * 2; j < MAX; j += i) {
					prime[j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean check[] = new boolean[MAX];
			int result[] = new int[MAX];
			Arrays.fill(result, -1);
			Queue<Integer> queue = new LinkedList<>();
			check[N] = true;
			result[N] = 0;
			queue.add(N);
			while(!queue.isEmpty()) {
				int num = queue.remove();
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j <= 9; j++) {
						if(i == 0 && j == 0)
							continue;
						else {
							int renew = change(num, i, j);
							if(!prime[renew] && !check[renew]) {
								queue.add(renew);
								check[renew] = true;
								result[renew] = result[num] + 1;
							}
						}
					}
				}
			}
			if(result[M] == -1)
				System.out.println("Impossible");
			else
				System.out.println(result[M]);
		}
	}
	static public int change(int num, int i, int j) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.setCharAt(i, (char) (j + '0'));
		return Integer.parseInt(sb.toString());
	}
}
