import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] w = new int[n+1];
		int [] v = new int[n+1];
		
		int [][]dp = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int max_val = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-w[i]>=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
					if(max_val < dp[i][j]) {
						max_val = dp[i][j];
					}
				}
			}
		}
		
		bw.append(String.valueOf(max_val));
		bw.flush();
		bw.close();
	}
}
