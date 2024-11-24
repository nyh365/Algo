import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int order = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < order; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j = 0; j < count; j++) {
					list.add(index + j, Integer.parseInt(st.nextToken()));
				}
			}
			for(int i = 0; i < 10; i++)
				sb.append(list.get(i)).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
