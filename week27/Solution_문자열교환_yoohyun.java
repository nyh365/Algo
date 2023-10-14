import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] input = br.readLine().toCharArray();
			
			int aCnt = 0;
			for(char a : input) {
				if(a == 'a') aCnt++;
			}
			
			int tail = 0;
			int bCnt = 0;
			for(;tail < aCnt; tail++) {
				if(input[tail] == 'b') bCnt++;
			}
			
			int result = bCnt;
			int head = 0, size = input.length;
			for(;head < size; head++) {
				if(input[head] == 'b') bCnt--;
				if(input[tail++ % size] == 'b') bCnt++;
				result = Math.min(result, bCnt);
			}
			System.out.print(result);
	}
}
