import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wonho = scores[0];
        
        Arrays.sort(scores, (a, b) 
                    -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        int max = scores[0][1];
        for(int i = 1; i < scores.length; i++){
            if(scores[i][1] >= max) {
                max = scores[i][1];
            } else {
                if(wonho[0] == scores[i][0] && wonho[1] == scores[i][1]){
                    return -1;
                }
                scores[i][0] = -1; scores[i][1] = -1;
            }
        }
        
        Arrays.sort(scores, (a, b) -> (b[0] + b[1]) - (a[0]+a[1]));
        int target = wonho[0] + wonho[1];
        int result = 1;
        for(int i = 0; i < scores.length; i++){
            if((scores[i][0] + scores[i][1]) > target){
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
