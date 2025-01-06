import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		boolean arr[] = new boolean[5000];
		for(int i = 2; i < 5000; i++) {
			if(!arr[i]) {
				list.add(i * i);
				for(int j = i * i; j < 5000; j += i)
					arr[j] = true;
			}
		}
		for(int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				while(N % tmp == 0) {
					N /= tmp;
				}
			}
			sb.append(N);
			System.out.println(sb);
		}
	}
}
