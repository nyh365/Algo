import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        return isOK(s);
    }
    
    boolean isOK(String s){
        Stack<Character> stack = new Stack<>();
        
        int length = s.length();
        char cur;
        for(int i = 0; i < length; i++){
            cur = s.charAt(i);
            if(cur == '('){
                stack.add(cur);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
