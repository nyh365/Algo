class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0, prev = -1, k = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == prev && i != 0) continue;

            nums[idx++] = nums[i];
            prev = nums[i];
            k++;
        }

        return k;
    }
}
