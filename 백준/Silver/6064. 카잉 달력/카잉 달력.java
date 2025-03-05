import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T, M, N, x, y, answer;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			answer = -1;
			
			if(y==N) {
				y=0;
			}
			
			for(int i=x; i<=M*N; i+=M) {
				if(i%N == y) {
					answer = i;
					break;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
