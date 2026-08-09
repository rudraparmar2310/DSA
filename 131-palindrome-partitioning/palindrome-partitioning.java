class Solution {
    List<List<String>> result = new ArrayList<>();    
    public List<List<String>> partition(String s) {
        solve(0, s, new ArrayList<>());
        return result;
    }  
    void solve(int start, String s, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String piece = s.substring(start, end + 1);
            
            if (isPalindrome(piece)) {
                path.add(piece);            
                solve(end + 1, s, path);      
                path.remove(path.size() - 1); 
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}