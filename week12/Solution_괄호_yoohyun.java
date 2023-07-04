import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++){
			sb.append(func(br.readLine())).append("\n");	
		}
		System.out.println(sb);	
	}
	public static String func(String s){
		Stack<Character> stack = new Stack<>();

		for(int i =0; i < s.length(); i++){
			char c = s.charAt(i);			

			if( c == '('){
				stack.push(c);
			}
			else{
				if(stack.empty()) return "NO";
				stack.pop();
			}
		}
		if(stack.empty()) return "YES";
		else return "NO";
	}			
}
