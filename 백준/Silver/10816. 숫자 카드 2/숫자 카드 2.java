import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> m = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(m.containsKey(num)) {
				m.put(num, m.get(num)+1);
			} else {
				m.put(num, 1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<s; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(m.containsKey(num)) {
				bw.append(String.valueOf(m.get(num)) + " ");
			} else {
				bw.append("0 ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
