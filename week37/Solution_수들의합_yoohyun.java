import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long N = Long.parseLong(br.readLine());
		int result = 0;
		
		for(int i = 1;; i++) {
			if(N - i < i + 1) {
				result++;
				break;
			}
			else {
				N -= i;
				result++;
			}
		}		
		System.out.println(result);
	}
}
