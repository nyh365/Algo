import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	
    	char[] first = br.readLine().toCharArray();
    	char[] second = br.readLine().toCharArray();

    	int firstSize = first.length;
    	int secondSize = second.length;
    	
    	int[][] dp = new int[firstSize + 1][secondSize + 1];
    	
    	
    	for(int i = 1; i <= firstSize; i++) {
    		for(int j = 1; j <= secondSize; j++) {
    			if(first[i - 1] == second[j - 1]) {
    				dp[i][j] = dp[i - 1][j - 1] + 1;
    			} else {
    				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
    			}
    		}
    	}
    	
    	int resultSize = dp[firstSize][secondSize];
    	sb.append(resultSize).append("\n");
    	
    	Stack<Character> stack = new Stack<>();
    	for(int i = firstSize; i >= 1; i--) {
    		for(int j = secondSize; j >= 1; j--) {
    			if(first[i - 1] == second[j - 1]) {
    				if(dp[i][j] == resultSize) {
    					resultSize--;
    					stack.add(second[j - 1]);
    					break;
    				}
    			}
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	
    	System.out.print(sb);
    }
}
