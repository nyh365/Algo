import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			while((st = new StringTokenizer(br.readLine())) != null) {
				String s1 = st.nextToken();
				char[] input = s1.toCharArray();
				int order = Integer.parseInt(st.nextToken());
				int cnt = 1;
				
				if(order == 1) {
					System.out.println(String.valueOf(input));
				}
				else {
					while(true) {
						if(next_permutation(input)) {
							++cnt;
							if(cnt == order) {
								System.out.println(s1 + " "+ (order) + " = " + String.valueOf(input));
								break;
							}
						}
						else {
							System.out.println(s1 + " "+ (order) + " = " + "No permutation");
							break;
						}
					}
				}
			}
		}catch(NullPointerException e) {
			
		}
		catch(Exception e) {
			
		}
	}
	public static boolean next_permutation(char[] input) {
		int i = input.length - 1;
		while(i > 0 && input[i - 1] >= input[i]) {
			i--;
		}
		if(i == 0) return false;
		
		int j = input.length - 1;
		while(input[i - 1] >= input[j]) {
			j--;
		}                                                                
		swap(input, i-1, j);
		int k = input.length - 1;
		while(i < k) {
			swap(input, i++, k--);
		}
		
		return true;
	}
	public static void swap(char[] input, int a, int b) {
		char c = input[a];
		input[a] = input[b];
		input[b] = c;
	}
}
