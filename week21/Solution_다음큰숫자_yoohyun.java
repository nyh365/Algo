class Solution {
    public int solution(int n) {
        int answer = 0;
        int max = Integer.toBinaryString(n).length() + 1;
        int target = Integer.bitCount(n);
        for(int i = n + 1;; i++){
            if(target == Integer.bitCount(i)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
