import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int P = Integer.parseInt(br.readLine());
        
        for(int testCase = 1; testCase <= P; testCase++) {
        	sb.append(testCase).append(" ");
        	LinkedList<Integer> student = new LinkedList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	st.nextToken();
        	
        	int result = 0;
        	for(int i = 0; i < 20; i++) {
        		int target = Integer.parseInt(st.nextToken());
        		
        		int index = i - 1;
        		while(index >= 0) {
        			if(student.get(index) < target) {
        				break;
        			}
        			index--;
        		}
        		result += i - (index + 1);
				student.add(index + 1, target);
        	}
        	sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
