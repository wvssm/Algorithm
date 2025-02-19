import java.util.*;
import java.io.*;


class Solution{
	static int N;
	static int map[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T;
		
		T= Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			int number = 1;
			int pos = 0;
			int x=0;
			int y=0;
			
			while(number <= N*N) {
				map[x][y] = number;
				int nx = x + dx[pos];
				int ny = y + dy[pos];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]!=0) {
					pos = (pos + 1) % 4;
					x += dx[pos];
					y += dy[pos];
				} else {
					x = nx;
					y = ny;
				}
				
				number++;
			}
			
			bw.append("#"+test_case+"\n");
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bw.append(map[i][j]+" ");
				}
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}
}