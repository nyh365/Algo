import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb;
        int length = s.length();
        for(int i = 0; i < length; i++){
            sb = new StringBuilder(s.substring(i, length));
            for(int j = 0; j < i; j++){
                sb.append(s.charAt(j));
            }
            if(isCorrect(sb.toString())){
                answer++;
            }
        }
        
        return answer;
    }
    boolean isOK(char l, char r){
        if(l == '['){
            if(r == ']') return true;
        } else if(l == '{'){
            if(r == '}') return true;
        } else if(l == '('){
            if(r == ')') return true;
        }
        return false;
    }
    boolean isCorrect(String s){
        Stack<Character> tmp = new Stack<>();
        
        int size = s.length();
        for(int i = 0; i < size; i++){
            if(tmp.isEmpty()){
                tmp.add(s.charAt(i));
            } else {
                if(isOK(tmp.peek(), s.charAt(i))){
                    tmp.pop();
                } else {
                    tmp.add(s.charAt(i));
                }
            }
        }
        
        return tmp.isEmpty() ? true : false;
    }
}
