import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++){
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				String[] input= br.readLine().split(" "); 
				if(flag) {
					if(input[1].charAt(0) >= '0' && input[1].charAt(0) <= '9') {
						if(input.length != 2) {
							result = 0;
							flag = true;
						}
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
