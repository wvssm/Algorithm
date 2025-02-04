import java.io.*;
import java.util.*;

class Main{		
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		boolean isAvailable = false;
		
		if(n%5==0) {
			answer = n/5;
			bw.append(String.valueOf(answer));
		}
		else {
			while(n>=0) {
				if(n%5==0) {
					answer += n/5;
					isAvailable = true;
					break;
				}
				answer++;
				n -= 3;
			}
			
			if(isAvailable) {
				bw.append(String.valueOf(answer));
			} else {
				bw.append(String.valueOf(-1));
			}
		}
		
		bw.flush();
		bw.close();
	}
}
