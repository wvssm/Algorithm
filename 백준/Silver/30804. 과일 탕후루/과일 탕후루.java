
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static Map<Integer, Integer> m; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		m = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		// 입력 받기
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int answer = 0;
		
		
		for(int right = 0; right < N; right++) {
			if(m.containsKey(arr[right])) {
				m.put(arr[right], m.get(arr[right])+1);
			} else {
				m.put(arr[right], 1);
			}
			
			while(m.size() > 2) {
				m.put(arr[left], m.get(arr[left])-1);
				
				if(m.get(arr[left]) == 0) {
					m.remove(arr[left]);
				}
				
				left++;
			}
			
			answer = Math.max(answer, right - left + 1);
		}
		
		System.out.println(answer);
	}
}
