
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, len;
	static int[] fr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());
		fr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			fr[i] = Integer.parseInt(st.nextToken());
		}
		snake();
		System.out.println(len);
		
	}
	static void snake() {
		int sum=0;
		int maxlen = len+N;
		while(len <= maxlen) {
			for (int i = 0; i < N; i++) {
				if(len >= fr[i] && fr[i] != 0) {
					sum++;
					fr[i] = 0;
				}
			}
			if(sum == 0) return;
			
			len += sum;
			sum = 0;
		}
	}
}
