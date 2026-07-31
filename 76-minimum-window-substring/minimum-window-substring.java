class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int required = tMap.size();
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int answerStart = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar,
                windowMap.getOrDefault(rightChar, 0) + 1);

            if (tMap.containsKey(rightChar) &&
                windowMap.get(rightChar).equals(tMap.get(rightChar))) {
                formed++;
            }
            while (formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    answerStart = left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar,
                    windowMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return "";

        return s.substring(answerStart, answerStart + minLength);
    }
}