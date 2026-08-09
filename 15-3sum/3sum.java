class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sums = nums[i] + nums[left] + nums[right];

                if(sums == 0){
                    List<Integer> Triplet = new ArrayList<>();
                    Triplet.add(nums[i]);
                    Triplet.add(nums[left]);
                    Triplet.add(nums[right]);
                    result.add(Triplet);

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(sums < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}