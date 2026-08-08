class Solution {
    List<List<Integer>> result = new ArrayList<>();  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>());
        return result;
    }  
    void solve(int start, int[] nums, List<Integer> path) {
        result.add(new ArrayList<>(path));       
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            solve(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}