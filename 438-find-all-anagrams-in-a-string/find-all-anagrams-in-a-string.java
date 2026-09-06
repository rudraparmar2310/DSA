class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>result=new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        int[]pfreq=new int[26];
        int[]sfreq=new int[26];
        for(char c:p.toCharArray()){
            pfreq[c-'a']++;
        }

        int k=p.length();
        for(int i=0;i<k;i++){
            sfreq[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pfreq,sfreq)){
            result.add(0);
        }
        for(int i=k;i<s.length();i++){
            sfreq[s.charAt(i)-'a']++;
            sfreq[s.charAt(i-k)-'a']--;
            if(Arrays.equals(pfreq,sfreq)){
                result.add(i-k+1);
            }
        }
        return result;
    }
}