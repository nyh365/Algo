import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine()) + 1;
		
		while(K > 0) {
			int remain = K % 2;
			K /= 2;
			
			if(remain == 0) {
				sb.append(4);
			} else {
				sb.append(7);
			}
		}

		System.out.print(sb.reverse().substring(1, sb.length()));
	}
}
