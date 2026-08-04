class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(nums, 0, current, answer);
        return answer;
    }
    public void generate(int[] nums, int index, List<Integer> current,
                            List<List<Integer>> answer) {

        if (index == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generate(nums, index + 1, current, answer);
        current.remove(current.size() - 1);
        generate(nums, index + 1, current, answer);
    }
}