import java.io.*;
import java.util.*;

public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		long start = 1, end = 2;

		while(start < end) {
			long temp = (long) Math.pow(end, 2) - (long) Math.pow(start, 2);

			if(temp < G) {
				end++;
			} else if(temp > G){
				start++;
			} else {
				sb.append(end).append("\n");
				end++;
				start++;
			}
		}
		System.out.print(sb.length() == 0 ? "-1" : sb);
	}
}
