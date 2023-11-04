import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            tmp[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp, new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        for(String input : tmp){
            answer += input;
        }
        if(tmp[0].equals("0"))
            return "0";
        
        return answer;
    }
}
