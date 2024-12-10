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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			int type1 = 0, type2 = 0, type3 = 0 ;
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				queue.add(Integer.parseInt(st.nextToken())); 
				queue.add(Integer.parseInt(st.nextToken()));
			}
			while(!queue.isEmpty()) {
				int x = queue.remove();
				int y = queue.remove();
				if(x > x1 && x < x2 && y > y1 && y < y2) type1++;
				else if(x < x1 || x > x2 || y < y1 || y > y2) type3++;
				else type2++;
			}
			sb.append(type1).append(" ").append(type2).append(" ").append(type3).append("\n");
		}
		System.out.print(sb);
	}
}
