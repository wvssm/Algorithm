import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input ="";
		
		while(true) {
			Stack<Character> st = new Stack<>();
			
			input = br.readLine();
			boolean isYes = true;
			
			if(input.equals(".")) {
				break;
			}
			
			// 돌기
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(' || input.charAt(i) == '[') {
					st.push(input.charAt(i));
				}
				else if(input.charAt(i) == ')') {
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					} else {
						isYes = false;
						break;
					}
				}
				else if(input.charAt(i) == ']') {
					if(!st.isEmpty() && st.peek() == '[') {
						st.pop();
					} else {
						isYes =false;
						break;
					}
				}
			}
			
			if(!st.isEmpty()) {
				isYes = false;
			}
			
			if(isYes == true) {
				bw.append("yes");
			} else {
				bw.append("no");
			}
			bw.newLine();
		}
		
		
		bw.flush();
		bw.close();
	}
}
