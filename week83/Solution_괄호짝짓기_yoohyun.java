import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++){
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			char[] input = br.readLine().toCharArray();
			int result = 1;
			for(int i = 0; i < N; i++) {
				if(input[i] == '(' || input[i] == '[' || input[i] == '{' || input[i] == '<')
					stack.add(input[i]);
				else {
					if(stack.isEmpty()) {
						result = 0;
						break;
					} else {
						char open = stack.peek();
						boolean flag = true;
						switch(input[i]) {
						case ')': if(open != '(') flag = false; break;
						case ']': if(open != '[') flag = false; break;
						case '}': if(open != '{') flag = false; break;
						case '>': if(open != '<') flag = false; break;
						}
						if(!flag) break;
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) result = 0;
			sb.append(result).append("\n");
		}
			System.out.println(sb);
	}
}
