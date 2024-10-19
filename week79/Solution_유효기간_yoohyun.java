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
			String input = br.readLine();
			int front = Integer.valueOf(input.substring(0, 2));
			int back = Integer.valueOf(input.substring(2, 4));
			String result = "";
			if(1 <=front && front <= 12 && 1 <= back && back <= 12)
				result = "AMBIGUOUS";
			else if((front > 12 && back > 12) || (front < 1 && back < 1) || (front < 1 && back > 12) || (front > 12 && back < 1))
				result = "NA";
			else if(back > 12 || back < 1)
				result = "MMYY";
			else if(front > 12 || front < 1)
				result = "YYMM";
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
