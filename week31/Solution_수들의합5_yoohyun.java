import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int result = 0, start = 1, end = 1, sum = 0;
		while(true) {
			if(sum == N) {
				result++;
			}
			if(sum > N) {
				sum -= start++;
			}else if(end == N + 1) {
				break;
			} else if(sum <= N) {
				sum += end++;
			} 
		}
		System.out.print(result);
	}
}
