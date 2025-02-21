import java.util.*;
import java.io.*;

class Main
 {
	static int[][] food;
	static boolean[] vis;
	static int N, answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 입력 받기
		N = Integer.parseInt(st.nextToken());

		food = new int[N][2];
		vis = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		answer = Integer.MAX_VALUE;
		subset(0,0);
		
		bw.append(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	
	static void subset(int depth, int cnt) {
		if(depth==N) {
			long sour= 1l;
			long bitter = 0l;
			
			if(cnt<1) {
				return;
			}
			
			for(int i=0; i<N; i++) {
				if(vis[i]) {
					sour *= food[i][0];
					bitter += food[i][1];
				}
			}
			
			if(answer > Math.abs((int)(sour - bitter))) {
				answer = Math.abs((int)(sour - bitter));
			}
			
			return;
		}
		
		vis[depth] = true;
		subset(depth+1, cnt+1);
			
		vis[depth] = false;
		subset(depth+1, cnt);
	}
}

