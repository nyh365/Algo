import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int result = 0;
		
		if(input < 100) {
			result = input;
		}
		else {
			result = 99;
			for(int i = 100; i <= input; i++) {
				int one = i % 10;
				int ten = (i / 10) % 10;
				int hundred = i / 100;
				
				if(one - ten == ten - hundred)
					result++;
			}			
		}
		
		
		System.out.print(result);
		
	}
}
