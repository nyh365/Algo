import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			StringBuilder sb = new StringBuilder();
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				char input = s.charAt(j);
				
				if(input == '-') {
					if(!left.isEmpty())
						left.pop();
				}
				else if(input == '>') {
					if(!right.isEmpty())
						left.add(right.pop());
				}
				else if(input == '<') {
					if(!left.isEmpty())
						right.add(left.pop());
				} 
				else{
					left.add(input);
				}
			}
			while(!left.isEmpty())
				right.push(left.pop());
			while(!right.isEmpty())
				sb.append(right.pop());
			System.out.println(sb);
		}
		
	}
}
