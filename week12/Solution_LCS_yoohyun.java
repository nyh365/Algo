import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		int memo[][] = new int[input1.length() + 1][input2.length() + 1];
		
		for(int i = 1; i <= input1.length(); i++) {
			char ic = input1.charAt(i - 1);
			for(int j = 1; j <= input2.length(); j++) {
				if(input2.charAt(j - 1) == ic) {
					memo[i][j] = memo[i-1][j - 1] + 1;
					
				}
				else {
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]); 
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int j = 1; j <= input2.length(); j++)
			max = Math.max(max, memo[input1.length()][j]);
		System.out.println(max);
		
	}
}
