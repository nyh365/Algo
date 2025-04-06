class Solution {
    public boolean canJump(int[] nums) {
        int possibleIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(possibleIndex < i) return false;
            possibleIndex = Math.max(possibleIndex, i + nums[i]);
        }
        return true;
    }
}
