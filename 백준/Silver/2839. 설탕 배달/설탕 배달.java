import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		int []dp = new int[n+1];

		Arrays.fill(dp, 5001);
		
		if(n>=3) {
			dp[3] = 1;
		}
		if(n>=5) {
			dp[5] = 1;
		}
		
		for(int i=6; i<=n; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5])+1;
		}
		
		if(dp[n] > 5000) {
			answer = -1;
		} else {
			answer = dp[n];
		}
		
		bw.append(String.valueOf(answer));
		
		bw.flush();
		bw.close();
	}
}
