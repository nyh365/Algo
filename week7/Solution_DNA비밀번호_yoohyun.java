import java.io.*;
import java.util.*;

class Main{
	static int[] DNA = new int[4];
	static int[] pass = new int[4];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Character> queue = new LinkedList<>();
		int result = 0;
		int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		char[] input = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			pass[i] =Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < P; i++) {
			queue.add(input[i]);
			if(input[i] == 'A') DNA[0]++;
			else if(input[i] == 'C') DNA[1]++;
			else if(input[i] == 'G') DNA[2]++;
			else if(input[i] == 'T') DNA[3]++;
		}
		if(isPass()) result++;
		for(int i = P; i < input.length; i++) {
			char c = queue.remove();
			if(c == 'A') DNA[0]--;
			else if(c == 'C') DNA[1]--;
			else if(c == 'G') DNA[2]--;
			else if(c == 'T') DNA[3]--;
			
			queue.add(input[i]);
			if(input[i] == 'A') DNA[0]++;
			else if(input[i] == 'C') DNA[1]++;
			else if(input[i] == 'G') DNA[2]++;
			else if(input[i] == 'T') DNA[3]++;
			if(isPass()) result++;
		}
		System.out.println(result);
	}
	public static boolean isPass() {
		for(int i = 0; i < 4; i++) {
			if(DNA[i] < pass[i]) return false;
		}
		return true;
	}
}
