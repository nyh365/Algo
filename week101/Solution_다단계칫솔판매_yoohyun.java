import java.util.*;

class Solution {
    private static HashMap<String, Integer> memberNum = new HashMap<>();
    private static HashMap<String, String> memberMap = new HashMap<>();
    private static int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int memberCnt = enroll.length;
        answer = new int[memberCnt];
        
        for(int i = 0; i < memberCnt; i++) {
            memberNum.put(enroll[i], i);
            memberMap.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }
        
        return answer;
    }
    
    public void dfs(String curMember, int income) {
        if(curMember.equals("-")) return;
        
        int[] divide = divideIncome(income);
        answer[memberNum.get(curMember)] += divide[1];
        if(divide[0] == 0) {
            return;
        }
        
        dfs(memberMap.get(curMember), divide[0]);
    }
    
    public int[] divideIncome(int income) {
        int divide = (int) (income * 0.1);
        
        if(divide > 0) {
            return new int[]{divide, income - divide};
        }
        return new int[] {0, income};
    }
}
