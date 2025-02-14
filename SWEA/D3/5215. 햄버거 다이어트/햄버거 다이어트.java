import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int nums[];
	static int arr[][];
	static int n, l, max;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			nums = new int[n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			
			combi(0,0,0,0);
			
			System.out.println("#"+test_case+" "+max);
		}
	}
	
	static void combi(int depth, int start, int like, int cal) {
		if(cal <= l) {
			if(max < like) {
				max = like;
			}
		}
		
		if(depth>=n) {
			return;
		}
		
		for(int i=start; i<n; i++) {
			combi(depth+1, i+1, like+arr[i][0], cal+arr[i][1]);
		}
	}
}