import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        int num = 0; int length = words.length;
        for(int i = 0; i < length; i++){
            num %= n;
            num++;
            if(words[i].length() != 1){
                if(i == 0 || words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)){
                    if(!set.contains(words[i])){
                        set.add(words[i]);
                        continue;
                    }
                }
            } 
            answer[0] = num; answer[1] = i / n + 1;
            break;
        }
        return answer;
    }
}
