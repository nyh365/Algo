import java.io.*;
import java.util.*;
  
public class Solution {
   public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean arr[] = new boolean[7];
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine()) - 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total = 0;
			int result = 1;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 7; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					total++;
					arr[i] = true;
				}
				else
					arr[i] = false;
			}
			result += N / total * 7;
			N %= total;
			for(int i = 0; i < 7; i++) {
				if(arr[i]) {
					int tmp = 0;
					int tmp_n = N;
					for(int j = (i + 1) % 7; tmp_n > 0; j = (j + 1) % 7) {
						if(arr[j]) {
							tmp_n--;
						}
						tmp++;
					}
					min = Math.min(min, tmp);
				}
			}
			result += min;
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
