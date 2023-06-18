import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String s = br.readLine();
		char c;
		for(int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			if(c == '('){
				stack.push(c);
			}		
			else{
				if(s.charAt(i - 1) == '('){
					stack.pop();
					result += stack.size();
				}
				else{
					stack.pop();
					result++;
				}
			}		
		}
		System.out.println(result);
	}
}
