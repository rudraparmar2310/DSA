class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x%10==0 && x!=0){
            return false;
        }
        long reversed=reverseHelper(x,0);
            return x == reversed;
        }
        public static long reverseHelper(int n,long result){
            if(n==0){
                return result;
            }
            int lastdigit=n%10;
            result = result * 10 + lastdigit;
            return reverseHelper(n/10,result);
        }
    }
