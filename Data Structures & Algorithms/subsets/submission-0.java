class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        return backtrack(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> backtrack (int[] nums , int index, List<Integer> curr, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(curr));
            return result;
        }

        curr.add(nums[index]);
        backtrack(nums, index+1, curr, result);
        curr.removeLast();
        backtrack(nums, index+1, curr, result);
        return result;

    }


}
