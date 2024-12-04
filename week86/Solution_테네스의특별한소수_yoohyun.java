import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		boolean arr[] = new boolean[1000001];
		arr[1] = true;
		for(int i = 2; i < 1000001; i++) {
			if(!arr[i]) {
				for(int j = 2 * i; j < 1000001; j += i) {
					arr[j] = true;
				}
			}
		}
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int result = 0;
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int i = A; i <= B; i++) {
				String s = String.valueOf(i);
				if(!arr[i]) {
					if(s.contains(D))
						result++;
				}
				
			}
			sb.append(result).append("\n");
			
			
		}
		System.out.println(sb);
	}
}
