import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int index = 1;
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		sb.append("<");
		
		while(!q.isEmpty()) {
			if(index%k==0) {
				int num = q.poll();
				sb.append(String.valueOf(num) + ", ");
				
			} else {
				q.add(q.poll());

			}
			index++;
		}
		
		bw.append(sb.toString().substring(0, sb.toString().length()-2));
		bw.append(">");
		
		bw.flush();
		bw.close();
	}
}
