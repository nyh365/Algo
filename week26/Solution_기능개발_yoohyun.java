import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int tmp;
        for(int i = 0; i < progresses.length; i++){
            tmp = 100 - progresses[i];
            progresses[i] = tmp / speeds[i] + (tmp % speeds[i] != 0 ? 1 : 0);
        }
        
        int cur = progresses[0]; int cnt = 1;
        for(int i = 1; i < progresses.length; i++){
            if(progresses[i] <= cur){
                cnt++;
            } else {
                result.add(cnt);
                cnt = 1;
                cur = progresses[i];
            }
            
            if(i == progresses.length - 1){
                result.add(cnt);
            }
        }  
        return result;
    }
}
