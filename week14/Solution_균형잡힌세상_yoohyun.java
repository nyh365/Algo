import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s;
		while(true){
			s = br.readLine();
			if(s.equals("."))
				break;
			sb.append(func(s)).append("\n");
		}
		System.out.println(sb);
	}
	public static String func(String s){
		Stack<Character> stack = new Stack<>();
		char c;
		for(int i = 0; i < s.length(); i++){
				c = s.charAt(i);
				if(c == '(' ||  c == '[')
					stack.push(c);
				else if( c == ')'){
					if(stack.isEmpty() || stack.peek() != '(') {
						return "no";
					}
					else if(stack.peek() == '(') {
						stack.pop();
					}
				}
				else if( c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						return "no";
					}
					else if(stack.peek() == '[') {
						stack.pop();
					}
				}
			}
			if(stack.isEmpty()){
				return "yes";
			}			
			else
				return "no";
	}
}
