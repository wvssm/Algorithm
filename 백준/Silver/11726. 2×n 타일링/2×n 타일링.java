import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		long []dp = new long[n+1];
		
		if(n<3) {
			bw.append(String.valueOf(n));
		} else {
			dp[1]=1l;
			dp[2]=2l;
			
			for(int i=3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
			
			bw.append(String.valueOf(dp[n] % 10007));
		}
		
		bw.flush();
		bw.close();
	}
}
