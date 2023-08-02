import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(true) {
			if(N % 5 == 0) {
				result += (N / 5);
				break;
			}
			else{
				N -= 3;
				result++;
			}
			if(N < 0) {
				result = -1;
				break;
			}
		}
		
		
		System.out.println(result);
	}
}
