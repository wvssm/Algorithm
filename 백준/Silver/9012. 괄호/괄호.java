import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String input = "";
		
		for(int i=0; i<n; i++) {
			Stack<Character> st = new Stack<>();
			input = br.readLine();
			boolean isYes = true;
			
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j)=='(') {
					st.push('(');
				}else if(input.charAt(j)==')') {
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					}else {
						isYes = false;
						break;
					}
				}
			}
			
			if(!st.isEmpty()) {
				isYes = false;
			}
			
			if(isYes==true) {
				bw.append("YES");
			}else {
				bw.append("NO");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}
