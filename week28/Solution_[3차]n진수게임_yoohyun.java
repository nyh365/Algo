class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder change = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < m * t; i++){
            change.append(Integer.toString(i, n));
        }
        
        int idx = p - 1; 
        for(int i = 0 ; i < t; i++, idx += m){
            answer.append(change.charAt(idx));
        }
        
        return answer.toString().toUpperCase();
    }
}
