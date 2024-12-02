import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			double N = Double.parseDouble(br.readLine()) * 0.001;
			int result = 0;
			if(N < 0.1) result = 0;
			else if(N < 1) result = 1;
			else if(N < 10) result = 2;
			else if(N < 100) result = 3;
			else if(N < 1000) result = 4;
			else result = 5;
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
