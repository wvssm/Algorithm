import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		// 입력 받기 
		int n = Integer.parseInt(br.readLine());
		
		String []arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		// 정렬 하기 
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		// 출력 하기 
		for(int i=0; i<n; i++) {
			if(i!=0 && arr[i-1].equals(arr[i])) {
				continue;
			}
			bw.append(arr[i]);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}