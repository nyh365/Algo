import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[] input = br.readLine().toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        int len = input.length;
        boolean flag = false;
        for(int i = 0; i < len; i++) {
            if(input[i] == '<') {
                flag = true;
                
                stackFlush(sb, stack);
                
                sb.append(input[i]);
            } else if(input[i] == '>') {
                flag = false;
            
                sb.append(input[i]);
            } else {
                if(flag) {
                    sb.append(input[i]);
                } else {
                    if(input[i] == ' ') {
                        stackFlush(sb, stack);
                        
                        sb.append(input[i]);
                    } else {
                        stack.add(input[i]);
                    }
                }
            }
        }
        
        stackFlush(sb, stack);
        
        System.out.print(sb);
    }
    public static void stackFlush(StringBuilder sb, Stack<Character> stack) {
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
