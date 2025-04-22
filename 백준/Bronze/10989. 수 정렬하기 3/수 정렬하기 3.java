import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int []cnt = new int[10001];
		int val = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			val = Integer.parseInt(br.readLine());
			cnt[val]++;
		}
		
		
		for(int i=1; i<=10000; i++) {
			while(cnt[i]>0) {
				bw.write(String.valueOf(i));
				bw.newLine();
				cnt[i]--;
			}
		}
		
		bw.flush();
		bw.close();
	}
}