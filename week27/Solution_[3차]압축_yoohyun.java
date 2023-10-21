import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 1; char c = 'A';
        HashMap<String, Integer> map = new HashMap<>();
        
        for(; i <=26 ; i++, c++){
            map.put(String.valueOf(c), i);
        } 
        
        StringBuilder sb = new StringBuilder().append(msg.charAt(0));
        StringBuilder tmp = new StringBuilder().append(msg.charAt(0));
        for(int cur = 1; cur < msg.length(); cur++){
            tmp.append(msg.charAt(cur));
            if(map.containsKey(tmp.toString())){
                sb.append(msg.charAt(cur));
                continue;
            } 
            answer.add(map.get(sb.toString()));
            map.put(tmp.toString(), i++);
            sb = new StringBuilder().append(msg.charAt(cur));
            tmp = new StringBuilder().append(msg.charAt(cur));
        }
        answer.add(map.get(sb.toString()));
        return answer;
    }
}
