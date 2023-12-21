import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			left.add(s.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			int command = input.charAt(0);
			if(command == 'L' && !left.isEmpty()) {
				right.add(left.pop());
			}
			else if(command == 'D' && !right.isEmpty()) {
				left.add(right.pop());
			}
			else if(command == 'B' && !left.isEmpty()) {
				left.pop();
			} 
			else if(command == 'P') {
				left.add(input.charAt(2));
			}
		}
		while(!left.isEmpty())
			right.push(left.pop());
		while(!right.isEmpty())
			sb.append(right.pop());
		System.out.print(sb);
	}
}
