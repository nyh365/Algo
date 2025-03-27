class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] sum = new int[n + 1];

        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                sum[n]++;
            } else {
                sum[citations[i]]++; 
            }
        }

        int result = 0;
        for(int i = n; i >= 0; i--) {
            result += sum[i];

            if(result >= i) {
                return i;   
            }
        }

        return 0;
    }
}
