import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 1;

        int size = s.length();
        for(int i = 0; i < size; i++){
            for(int j = 1; j < size - i; j++){
                if(isPalindrome(s, i, j + 1)){
                    answer = Math.max(answer, j + 1);
                }
            }
        }    
        return answer;
    }
    public boolean isPalindrome(String s, int start, int end){
        for(int i = 0; i < end / 2; i++){
            if(s.charAt(start + i) != s.charAt(end - 1 - i + start)) return false;
        }
        return true;
    }
}
