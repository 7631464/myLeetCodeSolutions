public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length<2 || k<1) return false;
        TreeSet<Integer> set=new TreeSet<Integer>();
        int len=nums.length;
        int i;
        for (i=0; i<len; i++) {
            if (i>k) set.remove(nums[i-k-1]);
            if (set.ceiling(nums[i])!=null && (long)set.ceiling(nums[i])-(long)nums[i]<=t) return true;
            if (set.floor(nums[i])!=null && (long)nums[i]-(long)set.floor(nums[i])<=t) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
