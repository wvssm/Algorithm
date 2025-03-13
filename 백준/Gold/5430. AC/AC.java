import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static Deque<Integer> dq;
	
	static int T, N;
	static String P;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			input();
			
			solution();
		}
		System.out.print(sb.toString());
	}
		
	static void input() throws IOException {
		P = br.readLine();
		N = Integer.parseInt(br.readLine());
		
		dq = new ArrayDeque<>();
		
		String input = br.readLine();
		String[] numbers = input.replace("[", "").replace("]", "").split(",");
		
		if(!numbers[0].equals("")) {
			for(String number : numbers) {
				dq.add(Integer.parseInt(number));
			}
		}
	}
	
	static void solution() {
		boolean isHead = true;
		boolean isError = false;
		
		for(int i=0; i<P.length(); i++) {
			if(P.charAt(i)== 'R') {
				isHead = !isHead;
			}
			else if(P.charAt(i) == 'D') {
				if(dq.isEmpty()) {
					isError = true;
					break;
				}
				else if(isHead) {
					dq.poll();
				} else {
					dq.pollLast();
				}
			}
		}
		
		if(isError) {
			sb.append("error\n");
		} else {
			sb.append("[");
			
			while(!dq.isEmpty()) {
				if(isHead) {
					sb.append(dq.poll());
				} else {
					sb.append(dq.pollLast());
				}
				if(!dq.isEmpty()) {
					sb.append(",");
				}
			}
			
			sb.append("]\n");
		}
	}
}
