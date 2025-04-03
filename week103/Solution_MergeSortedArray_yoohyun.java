class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Idx = 0, nums2Idx = 0;

        int[] result = new int[m + n];
        for(int i = 0; i < m + n; i++) {
            if(nums1Idx == m) {
                result[i] = nums2[nums2Idx++];
                continue;
            } 

            if(nums2Idx == n) {
                result[i] = nums1[nums1Idx++];
                continue;
            } 

            if(nums1[nums1Idx] <= nums2[nums2Idx]) {
                result[i] = nums1[nums1Idx];
                nums1Idx++;
            } else {
                result[i] = nums2[nums2Idx];
                nums2Idx++;
            }
        }

        for(int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}
