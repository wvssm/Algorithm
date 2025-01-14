import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main{
	public static void main(String args[]) throws IOException {
		final int RED = 0;
		final int GREEN = 1;
		final int BLUE = 2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][]cost = new int[n][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
			cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
			cost[i][BLUE] += Math.min(cost[i-1][RED], cost[i-1][GREEN]);
		}

		int answer = Math.min(cost[n-1][RED], Math.min(cost[n-1][GREEN],cost[n-1][BLUE]));
		
		bw.append(String.valueOf(answer));
		bw.flush();
	}
}