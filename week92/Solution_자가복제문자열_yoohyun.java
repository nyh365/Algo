import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			long K = Long.parseLong(br.readLine()) - 1;
			if(K % 4 == 0) {
				sb.append(0);
			}
			else if(K % 2 == 0)
				sb.append(1);
			else {
				while(K % 2 != 0) {
					K = (K - 1) / 2 ;
				}
				if(K % 4 == 0) {
					sb.append(0);
				}
				else if(K % 2 == 0)
					sb.append(1);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
