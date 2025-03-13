import java.io.*;
import java.util.*;

class Main{
	static char [][]map = new char[51][51];
	static int n = 0;
	static int m = 0;
	
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String board;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			board = st.nextToken();
			for(int j=0; j<m; j++) {
				map[i][j] = board.charAt(j);
			}
		}
		
		int sol = Integer.MAX_VALUE;
		int answer = 0;
		
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				answer = solve(i, j); 
				if(sol > answer) {
					sol = answer;
				}
			}
		}
			
		bw.append(String.valueOf(sol));
		
		bw.flush();
		bw.close();
	}
	
	static int solve(int x, int y) {
		int white_count = 0;
		int black_count = 0;
		
		String white_first = "WBWBWBWB";
		String black_first = "BWBWBWBW";
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(white_first.charAt(j) != map[x + i][y + j]) {
						white_count++;
					}
				}else {
					if(black_first.charAt(j) != map[x + i][y + j]) {
						white_count++;
					}
				}
			}
		}
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(black_first.charAt(j) != map[x + i][y + j]) {
						black_count++;
					}
				}else {
					if(white_first.charAt(j) != map[x + i][y + j]) {
						black_count++;
					}
				}
			}
		}

		return Math.min(white_count, black_count);
	}
}
