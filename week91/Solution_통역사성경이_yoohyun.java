import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case);
			int N = sc.nextInt();
			int cnt = 0;
			String input ="";
			while(cnt != N) {
				String input_tmp= sc.next();
				if(input_tmp.contains(".") || input_tmp.contains("?") || input_tmp.contains("!"))
					cnt++;
				input += input_tmp + " ";
			}
			input = input.substring(0, input.length() -1);
			StringTokenizer st = new StringTokenizer(input, ".?!");
			while(st.hasMoreTokens()) {
				int count = 0;
				String s = st.nextToken();
				StringTokenizer tmp = new StringTokenizer(s, " \n");
				while(tmp.hasMoreTokens()) {
					boolean flag = true;
					String tmp_s = tmp.nextToken();
					if(tmp_s.charAt(0) >= 'A' && tmp_s.charAt(0) <= 'Z') {
						for(int i = 1; i < tmp_s.length(); i++) {
							if(tmp_s.charAt(i) < 'a' || tmp_s.charAt(i) > 'z')
								flag = false;
						}
					}
					else
						flag = false;
					if(flag) count++;
				}
				sb.append(" ").append(count);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
