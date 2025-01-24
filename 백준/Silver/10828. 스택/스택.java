import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stk = new Stack<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String input = st.nextToken();
			if(input.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stk.push(num);
			} else if(input.equals("pop")) {
				if(stk.empty()) {
					bw.append("-1");
				} else {
					bw.append(String.valueOf(stk.pop()));
				}
				bw.newLine();
			} else if(input.equals("size")) {
				bw.append(String.valueOf(stk.size()));
				bw.newLine();
			} else if(input.equals("empty")) {
				if(stk.empty()) {
					bw.append("1");
				} else {
					bw.append("0");
				}
				bw.newLine();
			} else if(input.equals("top")) {
				if(stk.empty()) {
					bw.append("-1");
				} else {
					bw.append(String.valueOf(stk.peek()));
				}
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}
}
