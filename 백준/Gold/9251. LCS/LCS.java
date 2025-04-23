import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static String str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        input();

        dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }

    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().trim();
        str2 = br.readLine().trim();
    }
}