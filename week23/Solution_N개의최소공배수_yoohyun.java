import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
       
        answer = arr[0];
        int length = arr.length;
        for(int i = 1; i < length; i++){
            answer = (arr[i]* answer) / gcd(arr[i], answer);
        }
        
        return answer;
    }
    public int gcd(int a, int b){
        if(a % b == 0){
            return b;
        } 
        return gcd(b, a % b);
    }
}
