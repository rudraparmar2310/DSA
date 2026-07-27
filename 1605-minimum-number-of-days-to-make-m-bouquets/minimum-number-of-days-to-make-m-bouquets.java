class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;           
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                ans = mid;         
                high = mid - 1;     
            } else {
                low = mid + 1;     
            }
        }        
        return ans;
    }   
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0, streak = 0;      
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                streak++;
                if (streak == k) {
                    bouquets++;
                    streak = 0;
                }
            } else {
                streak = 0;  
            }
        }       
        return bouquets >= m;
    }
}