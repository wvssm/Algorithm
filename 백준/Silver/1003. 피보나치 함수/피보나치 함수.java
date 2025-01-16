import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	static int[] zero = new int[41];
	static int[] one = new int[41];
	
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int j=2; j<=n; j++) {
				zero[j] = zero[j-1] + zero[j-2];
				one[j] = one[j-1] + one[j-2];
			}
			
			bw.append(String.valueOf(zero[n]) + " " + String.valueOf(one[n]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}