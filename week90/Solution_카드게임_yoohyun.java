import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] dec_point = {0,0,4,4,4,4,4,4,4,4,16,4};
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int tmp;
			int sum = 0, down = 0, up = 0;
			for(int i = 0; i < N; i++) {
				tmp = Integer.parseInt(br.readLine());
				dec_point[tmp]--;
				sum += tmp;
			}
			for(int i = 2; i <= 11; i++) {
				if(dec_point[i] > 0) {
					if(i + sum > 21) up += dec_point[i];
					else down+= dec_point[i];
				}
			}
			if(down <= up)
				sb.append("STOP");
			else
				sb.append("GAZUA");
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
