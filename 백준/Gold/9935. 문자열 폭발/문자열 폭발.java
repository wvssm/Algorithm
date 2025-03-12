import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static Stack<Character> stk;
	
	static int N;
	static String inputString;
	static String compareString;
	static String answer;

	public static void main(String[] args) throws IOException {
		input();
		
		stringBomb();
		
		printResult();
	}
		
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		inputString = br.readLine();
		compareString = br.readLine();
	}
	
	static void stringBomb() {
		stk = new Stack<>();
		
		// 1. 글자 들을 모두 stack에 넣는다.
		for(int i=0; i<inputString.length(); i++) {
			stk.push(inputString.charAt(i));
			
			// 2. 현재 stack 넣은 숫자가 길이보다 크다면
			if(stk.size() >= compareString.length()) {
				int count = 0;
				// 3. 폭발 문자가 있는지 비교하고
				for(int j=0; j<compareString.length(); j++) {
					if(stk.get(stk.size()-j-1) == compareString.charAt(compareString.length()-1-j)) {
						count++;
					}
				}
				// 4. 폭발 문자가 있다면 해당 개수만큼 pop한다.
				if(count == compareString.length()) {
					while(count>0) {
						stk.pop();
						count--;
					}
				}
			}
		}
	}
	
	static void printResult() {
		sb = new StringBuilder();
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.reverse().toString());
		}
	}
}
