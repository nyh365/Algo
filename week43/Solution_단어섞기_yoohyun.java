import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Main{
	static char[] element1;
	static char[] element2;
	static char[] result;
	static boolean isDataSet;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int test_case = 1; test_case <= N; test_case++) {
    		sb.append("Data set ").append(test_case).append(": ");
    		
    		st = new StringTokenizer(br.readLine());
    		Set<Character> set = new HashSet<>();
    		
    		element1 = st.nextToken().toCharArray();
    		element2 = st.nextToken().toCharArray();
    		result = st.nextToken().toCharArray();
    		
    		for(Character c : element1) {
    			set.add(c);
    		}
    		
    		for(Character c : element2) {
    			set.add(c);
    		}
    		boolean flag = true;
    		for(Character c : result) {
    			if(!set.contains(c)) {
    				flag = false;
    				break;
    			}
    		}
    		
    		if(!flag) {
    			sb.append("no").append("\n");
    			continue;
    		}
    		
    		isDataSet = false;
    		dfs(0,0,0);
    		
    		sb.append(isDataSet ? "yes" : "no").append("\n");
    	}
    	System.out.print(sb);
    }
	public static void dfs(int index1, int index2, int resultIndex) {
		if(isDataSet) return;
		
		if(index1 == element1.length && index2 == element2.length) {
			isDataSet = true;
			return;
		}
		
		boolean isContain1 = index1 < element1.length ? element1[index1] == result[resultIndex] : false;
		boolean isContain2 = index2 < element2.length ? element2[index2] == result[resultIndex] : false;
		
		if(isContain1) dfs(index1 + 1, index2, resultIndex + 1);
		if(isContain2) dfs(index1, index2 + 1, resultIndex + 1);
	}
}
