class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int right = s.length() - 1;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) break;
            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            ans.append(s, left + 1, right + 1);
            ans.append(" ");

            right = left - 1;
        }
        return ans.toString().trim();
    }
}