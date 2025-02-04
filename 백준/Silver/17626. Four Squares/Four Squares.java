import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int []dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		bw.append(String.valueOf(dp[n]));
		
		bw.flush();
		bw.close();
	}
}