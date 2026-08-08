class Solution {
    List<String> result = new ArrayList<>(); 
    public List<String> validStrings(int n) {
        solve(new StringBuilder(), n);
        return result;
    }  
    void solve(StringBuilder path, int n) {
        if (path.length() == n) {
            result.add(path.toString());
            return;
        }     
        if (path.length() == 0 || path.charAt(path.length() - 1) == '1') {
            path.append('0');
            solve(path, n);
            path.deleteCharAt(path.length() - 1);
        }      
        path.append('1');
        solve(path, n);
        path.deleteCharAt(path.length() - 1);
    }
}