import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String s = Integer.toBinaryString(M);
			String result = "ON";
			int i = 0;
			if(N <= s.length()) {
				i = s.length() - N;
				for(; i < s.length(); i++) {
					if(s.charAt(i) -'0' != 1) {
						result = "OFF";
								break;
					}
				}
			}
			else
				result = "OFF";
			System.out.println("#" + test_case + " " + result);
		}
	}
}
