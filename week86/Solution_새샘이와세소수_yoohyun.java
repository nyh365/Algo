import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean isPrime[] = new boolean[1000];
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 2; i < 1000; i++) {
			if(!isPrime[i]) {
				for(int j = 2 * i; j < 1000; j += i) {
					isPrime[j] = true;
				}
				prime.add(i);
			}
		}
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			for(int x = 0;; x++) {
				int i = prime.get(x); 
				if(i > N - 4)
					break;
				for(int y = x;; y++) {
					int j = prime.get(y);
					if(j > N - 2 - i)
						break;
					for(int z = y;; z++) {
						if(i + j + prime.get(z) > N) 
							break;
						if(i + j + prime.get(z) == N) {
							count++;
							break;
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}
