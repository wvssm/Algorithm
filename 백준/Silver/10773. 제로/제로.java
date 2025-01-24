import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				st.pop();
			} else {
				st.push(num);
			}
		}
		
		int sum = 0;
		while(!st.empty()) {
			sum += st.pop();
		}
		
		bw.append(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
