class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (seen[currentChar - 'a']) {
                continue;
            }
            while (!stack.isEmpty()
                    && stack.peek() > currentChar
                    && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }
            stack.push(currentChar);
            seen[currentChar - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.reverse().toString();
    }
}