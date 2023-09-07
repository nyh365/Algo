class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int num = s.replaceAll("0", "").length();
        answer[0] = 1;
        answer[1] = s.length() - num;
        
        while(num != 1){
            s = Integer.toBinaryString(num);
            num = s.replaceAll("0", "").length();
            answer[0]++;
            answer[1] += s.length() - num;
        }   
        
        return answer;
    }
}
