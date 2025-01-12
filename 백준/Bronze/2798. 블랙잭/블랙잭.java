import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int []arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0l;
		long gap = 300000l;
		long answer = 0l;
		
		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					sum += arr[i] + arr[j] + arr[k];
					if(Math.abs(m-sum) < gap && sum <= m){
						gap = Math.abs(m-sum);
						answer = sum;
					}
					sum = 0;
				}
			}
		}
		
		System.out.println(answer);
	}
}