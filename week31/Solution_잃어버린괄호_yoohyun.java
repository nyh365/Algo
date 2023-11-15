import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] sub = input.split("-");
		int result = -1; 
		for(int i = 0; i < sub.length; i++) {
			int tmp = 0;
			String[] sub_sub = sub[i].split("\\+");
			for(String s : sub_sub) {
				tmp += Integer.valueOf(s);
			}
			
			if(i == 0) {
				result = tmp;
			}
			else {
				result -= tmp;
			}
			
		}
		System.out.println(result);
	}
}
