public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i=0; i<len; i++) { //dp[i+1];
            dp[i+1]=false;
            for (int j=i; j>=0; j--) {
                  dp[i+1]= dp[i+1] || (dp[j] && wordDict.contains(s.substring(j, i+1)) );
                  if (dp[i+1]==true) break;
            }
        }
        return dp[len];
    }
}
