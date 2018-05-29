import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
	        boolean[] dp = new boolean[s.length() + 1];
	        List<String> words[] = new ArrayList[dp.length];
	        dp[0] = true;
	        for(int i = 1;i <= s.length(); i++){
	            for(int j = 0;j < i; j++){
	                if(dp[j] && wordDict.contains(s.substring(j,i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];
	}

	public static void main(String[] args) {
		String str = "aaaaaa";
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(str, Arrays.asList("aaaa","aa")));
	}
}