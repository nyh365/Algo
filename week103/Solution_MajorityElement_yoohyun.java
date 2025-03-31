class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int k = -1;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                k = nums[i];
            }

            if(k != nums[i]) {
                count--;
            } else {
                count++;
            }
        }

        return k;
    }
}
