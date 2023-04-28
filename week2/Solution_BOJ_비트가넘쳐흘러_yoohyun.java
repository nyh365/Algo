import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(s[i] == '1') result++;
		}
		System.out.println(result);
	}
}
