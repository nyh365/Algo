import java.util.*;
class Solution
{
    public int solution(String s){
        return isOk(s);
    }
    
    int isOk(String s){
        Stack<Character> stack = new Stack<>();
        
        int length = s.length();
        char cur;
        for(int i = 0; i < length; i++){
            cur = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek() == cur){
                    stack.pop();
                    continue;
                }
            }
            stack.add(cur);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
