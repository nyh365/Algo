class Solution {
    public int jump(int[] nums) {
        int cnt = 0, possibleIdx = 0, prefixIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(possibleIdx >= nums.length) break;

            if(possibleIdx < i) {
                cnt++;
                possibleIdx = prefixIdx;
            } 
            prefixIdx = Math.max(prefixIdx, i + nums[i]);
        }

        return cnt;
    }
}
